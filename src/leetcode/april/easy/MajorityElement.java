package leetcode.april.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/majority-element
 */

public class MajorityElement {

    public int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        if(nums.length % 2 == 0) {
            return nums[nums.length/2 -1];
        } else {
            return nums[nums.length/2];
        }
    }

    public static void main(String[] args) {
        MajorityElement excelSheetColumnTitle = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(excelSheetColumnTitle.majorityElement(nums));
    }

}
