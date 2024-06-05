package scaler;

import java.util.*;
import java.util.stream.Collectors;

public class Countuniqueelements {

    public int solve(List<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer elem : A) {
            if (map.containsKey(elem)) {
                map.put(elem, map.get(elem) + 1);
            } else {
                map.put(elem, 1);
            }
        }
        return (int) map.values().stream().filter(integer -> integer<=1).count();
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3, 4, 3, 6, 6};
        Countuniqueelements commonElements = new Countuniqueelements();
        System.out.println(commonElements.solve(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }

}
