package scaler;

import java.util.*;
import java.util.stream.Collectors;

public class SubarraySumEqualsK {
    public int solve(List<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        int pf = 0;
        map.put(0, 1);
        int count = 0;
        for(int i=0; i<A.size(); i++) {
            pf = pf + A.get(i);
            if(map.containsKey(pf - B)) count = count + map.get(pf - B);
            map.put(pf, map.getOrDefault(pf, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-14,-9,12,7,-12,-4,7,25,-5,48,33,-49,36,-31,-48,36,36,17,13,-47,-39,37,-20,35,38,26,-40,-43,36,-48,-33,-30,6,-28,11,27,22,18,-21,-11,-50,34,-21,44,-25,17,34,-12,14,26,30};
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        subarraySumEqualsK.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 16);
    }

}
