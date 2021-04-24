package leetcode.medium;

/**
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 */
public class PartitionArrayforMaximumSum {

    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length, dp[] = new int[N];
        for (int i = 0; i < N; ++i) {
            int curMax = 0;
            for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
                curMax = Math.max(curMax, A[i - k + 1]);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
            }
        }
        return dp[N - 1];
    }


    public static void main() {
        PartitionArrayforMaximumSum partitionArrayforMaximumSum = new PartitionArrayforMaximumSum();
        int[] arr = {1,4,1,5,7,3,6,1,9,9,3};
        int K = 4;
        System.out.println(partitionArrayforMaximumSum.maxSumAfterPartitioning(
                arr,
                K
        ));
    }
}
