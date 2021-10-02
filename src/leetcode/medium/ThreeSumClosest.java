package leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int resultSum = nums[0] + nums[1] + nums[nums.length-1];
        for(int i=0; i<nums.length-2; i++) {
            int start = i+1, end = nums.length-1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum > target) {
                    end--;
                } else {
                    start++;
                }
                if(Math.abs(sum - target) < Math.abs(resultSum - target)) {
                    resultSum = sum;
                }
            }
        }
        return resultSum;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(arr, 1));
    }

}
