package scaler;

import java.util.*;
import java.util.stream.Collectors;

public class AddOneToNumber {

    public ArrayList<Integer> plusOne(List<Integer> A) {
        int n = A.size();
        int carryForward = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1 && A.get(i) + 1 < 10) {
                carryForward = 0;
                res.add(A.get(i) + 1);
            } else if (i == n - 1 && A.get(i) + 1 >= 10) {
                carryForward = 1;
                res.add(0);
            } else if (A.get(i) + carryForward >= 10) {
                carryForward = 1;
                res.add(0);
            } else {
                res.add(A.get(i) + carryForward);
                carryForward = 0;
            }
        }
        if (carryForward == 1) res.add(1);
        Collections.reverse(res);

        Iterator<Integer> it = res.iterator();
        int i = 0;
        while (it.hasNext() && it.next() == 0) {
            ++i;
        }
        res.subList(0, i).clear();
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{0, 0, 0, 9, 9};
        AddOneToNumber addOneToNumber = new AddOneToNumber();
        System.out.println(addOneToNumber.plusOne(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }

}
