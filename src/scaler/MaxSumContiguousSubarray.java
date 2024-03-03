package scaler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxSumContiguousSubarray {

    public int maxSubArray(final List<Integer> A) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSumContiguousSubarray maxSumContiguousSubarray = new MaxSumContiguousSubarray();
        System.out.println(maxSumContiguousSubarray.maxSubArray(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }

}
