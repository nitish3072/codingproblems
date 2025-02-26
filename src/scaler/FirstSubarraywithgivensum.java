package scaler;

import java.util.*;
import java.util.stream.Collectors;

public class FirstSubarraywithgivensum {
    public ArrayList<Integer> solve(List<Integer> A, int B) {
        Map<Long, Integer> map = new HashMap<>();
        long pf = 0;
        map.put(0L, -1);
        for(int i=0; i<A.size(); i++) {
            pf = pf + A.get(i);
            if(map.containsKey(pf - B)) {
                return new ArrayList<>(A.subList(map.get(pf -B) + 1, i+1));
            }
            map.put(pf, i);
        }
        return new ArrayList<>(Arrays.asList(-1));
    }

    public static void main(String[] args) {
        int[] ints = new int[]{15,2,5,6,9};
        FirstSubarraywithgivensum subarraySumEqualsK = new FirstSubarraywithgivensum();
        subarraySumEqualsK.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 7);
    }
}
