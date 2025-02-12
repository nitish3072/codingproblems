package scaler;

import java.util.*;
import java.util.stream.Collectors;

public class CountPairDifference {

    public int solve(List<Integer> B, int A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Long count = 0L;
        map.put(B.get(0), 1);
        for (int i = 0; i < B.size(); i++) {
            Integer elem = B.get(i);
            Integer target1 = A + elem;
            Integer target2 = A - elem;
            if(map.containsKey(target1)) {
                count = count + map.get(target1);
            }
            if(map.containsKey(target2)) {
                count = count + map.get(target2);
            }
            if(map.containsKey(elem)) {
                map.put(elem, map.get(elem) + 1);
            } else {
                map.put(elem, 1);
            }
        }
        return count.intValue();
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 1, 2};
        CountPairDifference countPairDifference = new CountPairDifference();
        System.out.println(countPairDifference.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 1));
    }

}
