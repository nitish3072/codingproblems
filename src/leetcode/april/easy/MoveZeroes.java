package leetcode.april.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 * 1) Start by finding the first zero in the array
 * 2) If no zero is present then return the function
 * 3) Swap current position with startIndexZero to move the bunch of zeros like a caterpillar. Caterpillar(head is at right side) eats non-zero numbers and is unable to digest them, so it takes it out at the tail. Now if it encounters zero then it eats it and digests it by increasing it size by 1.
 * 4) This is also known as sliding window algorithm
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int startIndexZero = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                startIndexZero = i;
                break;
            }
        }
        if(startIndexZero==-1) return;

        for (int i = startIndexZero+1; i < nums.length; i++) {
            if(nums[i] != 0) {
                swap(nums, startIndexZero, i);
                startIndexZero++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(nums);
    }
}
