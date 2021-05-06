package leetcode.medium;

/**
 * https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays
 */
public class MaximumSumTwoNonOverlappingSubarrays {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        for(int i=1; i<A.length; i++) {
            A[i] += A[i-1];
        }
        // This max is done so that we check order of (L and M) - (M and L) respectively in order
        return Math.max(maxSum(A, L, M), maxSum(A, M, L));
    }

    private int maxSum(int[] A, int L, int M) {
        // Get sum array till index elements
        // Fill value for sumM and sumL
        // There are 2 ways to get max sum
        // 1) L and M are together in order and they give max result - Max(previousMax, L elements + M elements) (Attached solution)
        // 2) L is some which is not attached to M. In that case we have to see which L is the max to compute maxL. Now result is Max(res, sumM + maxL)
        int sumM = A[L+M-1] - A[L-1];
        int sumL = A[L-1];
        int res = sumL + sumM;

        int maxL = sumL;
        for(int i=L+M ;i<A.length;i++) {
            sumL = A[i - M] - A[i - M - L];
            sumM = A[i] - A[i-M];
            maxL = Math.max(sumL, maxL);
            res = Math.max(res, sumM + maxL);
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumSumTwoNonOverlappingSubarrays maximumSumTwoNonOverlappingSubarrays = new MaximumSumTwoNonOverlappingSubarrays();
        int[] arr = {0,6,5,2,2,5,1,9,4};
        System.out.println(maximumSumTwoNonOverlappingSubarrays.maxSumTwoNoOverlap(arr, 1, 2));
    }

}
