package scaler.dp1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxProductSubarray {

    public int maxProduct(final List<Integer> A) {
        int[] dpMin = new int[A.size()];
        int[] dpMax = new int[A.size()];
        dpMin[0] = A.get(0);
        dpMax[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) == 0) {
                dpMin[i] = 0;
                dpMax[i] = 0;
            } else {
                dpMin[i] = Math.min(A.get(i), Math.min(A.get(i) * dpMin[i - 1], A.get(i) * dpMax[i - 1]));
                dpMax[i] = Math.max(A.get(i), Math.max(A.get(i) * dpMin[i - 1], A.get(i) * dpMax[i - 1]));
            }
        }
        return Arrays.stream(dpMax).max().getAsInt();
    }

    public static void main(String[] args) {
        MaxProductSubarray obj = new MaxProductSubarray();
        System.out.println(obj.maxProduct(List.of(4,2,-5,1)));
    }

}
