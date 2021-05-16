package leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array/
 */
public class SumAbsoluteDifferencesInSortedArray {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        int sumTillIndex = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = totalSum - 2 * sumTillIndex - nums.length * nums[i] + 2 * i * nums[i];
            sumTillIndex += nums[i];
        }
        return dp;
    }

    public static void main(String[] args) {
        SumAbsoluteDifferencesInSortedArray sumAbsoluteDifferencesInSortedArray = new SumAbsoluteDifferencesInSortedArray();
        int[] arr = {2,3,5};
        System.out.println(Arrays.toString(sumAbsoluteDifferencesInSortedArray.getSumAbsoluteDifferences(arr)));
    }

}
