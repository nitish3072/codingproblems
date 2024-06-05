package scaler;

import java.util.*;
import java.util.stream.Collectors;

public class CommonElements {

    public ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer elem : A) {
            if (map.containsKey(elem)) {
                map.put(elem, map.get(elem) + 1);
            } else {
                map.put(elem, 1);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer elem : B) {
            if(map.containsKey(elem) && map.get(elem) > 0) {
                map.put(elem, map.get(elem)-1);
                result.add(elem);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,1,1};
        int[] ints2 = new int[]{1,2};
        CommonElements commonElements = new CommonElements();
        System.out.println(commonElements.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), Arrays.stream(ints2).boxed().collect(Collectors.toList())));
    }

}
