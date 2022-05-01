package leetcode.april.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum/
 * Use Map to make it fast. Search for remaining number in map for every element of the array.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[][] numsArrWithIndex = new int[2][nums.length];
        for(int i=0; i<nums.length; i++) {
            numsArrWithIndex[0][i] = i;
            numsArrWithIndex[1][i] = nums[i];
        }
        Arrays.sort(nums);
        int first = nums[0];
        int second = nums[nums.length-1];
        int leftPtr = 0;
        int rightPtr = nums.length-1;
        while(leftPtr<rightPtr) {
            if(nums[leftPtr] + nums[rightPtr] == target) {
                first = nums[leftPtr];
                second = nums[rightPtr];
                break;
            }
            if(nums[leftPtr] + nums[rightPtr] > target) {
                rightPtr--;
            } else {
                leftPtr++;
            }
        }
        int[] finalArray = new int[2];
        Arrays.fill(finalArray, -1);
        for(int i=0; i<nums.length; i++) {
            if(numsArrWithIndex[1][i] == first && finalArray[0]==-1) {
                finalArray[0] = numsArrWithIndex[0][i];
            } else if(numsArrWithIndex[1][i] == second && finalArray[1]==-1) {
                finalArray[1] = numsArrWithIndex[0][i];
            }
        }
        return finalArray;
    }

    public static void main(String[] args) {
        TwoSum addStrings = new TwoSum();
        int[] arr = { 2,5,5,11 };
        System.out.println(Arrays.toString(addStrings.twoSum(arr, 10)));
    }
}
