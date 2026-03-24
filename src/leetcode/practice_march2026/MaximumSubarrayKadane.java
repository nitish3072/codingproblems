package leetcode.practice_march2026;

public class MaximumSubarrayKadane {

    // Kadanes Algo
    public int maxSubArray(int[] nums) {
        int runningSum = 0;
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            maxSum = Math.max(maxSum, runningSum);
            if(runningSum < 0) runningSum = 0;
        }
        return maxSum;
    }

}
