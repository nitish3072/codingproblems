package scaler;

import java.util.*;
import java.util.stream.Collectors;

public class SubarraywithZerosum {

    public int solve(List<Integer> A) {
        int[] prefixSum = new int[A.size()];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.size(); i++) {
            prefixSum[i] = (i - 1 < 0) ? A.get(0) : prefixSum[i - 1] + A.get(i);
            if(prefixSum[i] == 0) return 1;
            if(set.contains(prefixSum[i])) return 1;
            set.add(prefixSum[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, -5, 5};
        SubarraywithZerosum subarraywithZerosum = new SubarraywithZerosum();
        System.out.println(subarraywithZerosum.solve(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }

}
