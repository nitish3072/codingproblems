package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subarraywithgivensum {

    public ArrayList<Integer> solve(List<Integer> A, int B) {
        int i = 0, j = 0, sum = A.get(0);
        while (j < A.size()) {
            if (sum < B) {
                j++;
                if(j>=A.size()) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(-1);
                    return list;
                }
                sum += A.get(j);
            } else if (sum > B) {
                sum -= A.get(i);
                i++;
            } else return new ArrayList<>(A.subList(i, j + 1));
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        return list;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5};
        Subarraywithgivensum sw = new Subarraywithgivensum();
        System.out.println(sw.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 5));
    }
}
