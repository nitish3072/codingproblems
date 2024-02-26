package scaler;

import java.util.List;

public class EquilibriumIndexArray {

    public int solve(List<Integer> A) {
        int n = A.size();
        int[] prefixSum = new int[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i] = (i - 1 < 0) ? A.get(0) : prefixSum[i - 1] + A.get(i);
        }
        for (int i = 0; i < n; i++) {
            int leftSum = i - 1 < 0 ? 0 : prefixSum[i - 1];
            int rightSum = prefixSum[n - 1] - prefixSum[i];
            if (leftSum == rightSum) return i;
        }
        return -1;
    }

}
