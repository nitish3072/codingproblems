package scaler;

import java.util.*;
import java.util.stream.Collectors;

public class FirstRepeatingelement {

    public int solve(List<Integer> A) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (Integer elem : A) {
            if (map.containsKey(elem)) {
                map.put(elem, true);
            } else {
                map.put(elem, false);
            }
        }
        for (Integer elem : A) {
            if (map.containsKey(elem) && map.get(elem)) {
                return elem;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{10, 5, 3, 4, 3, 5, 6};
        FirstRepeatingelement countdistinctelements = new FirstRepeatingelement();
        System.out.println(countdistinctelements.solve(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }

}
