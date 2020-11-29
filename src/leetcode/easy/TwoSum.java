package leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] num = Arrays.stream(nums).sorted().toArray();
        int i=0, j=nums.length-1;
        while (i!=j) {
            if(num[i] + num[j] > target) {
                j--;
            } else if(num[i] + num[j] < target) {
                i++;
            } else if((num[i] + num[j] == target)) {
                break;
            }
        }
        return new int[]{i, j};
    }

    public static void main(String[] args) {
        TwoSum addStrings = new TwoSum();
        int[] arr = { 2,7,11,15 };
        System.out.println(Arrays.toString(addStrings.twoSum(arr, 9)));
    }
}
