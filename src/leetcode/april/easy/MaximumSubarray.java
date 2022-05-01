package leetcode.april.easy;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * Kadanes Algorithm
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0; i<nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum+nums[i]);
//            if(currentSum <= nums[i] && currentSum<0) currentSum = nums[i];
//            else currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {5,4,-1,7,8};
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(a));
    }

}
