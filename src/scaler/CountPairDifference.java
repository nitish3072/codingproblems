package scaler;

import java.util.*;
import java.util.stream.Collectors;

public class CountPairDifference {

    public int solve(List<Integer> B, int A) {
        Map<Integer, Integer> map = new HashMap<>();
        Long count = 0L;
        for (int i = 0; i < B.size(); i++) {
            Integer elem = B.get(i);
            map.put(elem, map.getOrDefault(elem, 0) + 1);
        }
        for (int i = 0; i < B.size(); i++) {
            Integer elem = B.get(i);
            Integer target1 = A + elem;
            if(map.containsKey(target1)) {
                count = count + map.get(target1);
            }
        }
        return count.intValue();
    }

    public static void main(String[] args) {
        int[] ints = new int[]{988,264,598,236,659,271,398,766,849,91,544,977,948,55,964,323,664,722,79,886,874,431,537,246,748,734,93,636,501,73,508,526,14,144,194,4,77,365,784,325,918,57,40,280,261,741,717,459,445,666,800,720};
        CountPairDifference countPairDifference = new CountPairDifference();
        System.out.println(countPairDifference.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 420));
    }

}
