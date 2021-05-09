package leetcode.medium;

/**
 * https://leetcode.com/problems/non-decreasing-array/submissions/
 */
public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int totalNonDecreasing = 0;
        for(int i = 1; i < nums.length && totalNonDecreasing<=1 ; i++){
            if(nums[i-1] > nums[i]){
                totalNonDecreasing++;
                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
            }
        }
        return totalNonDecreasing <= 1;
    }

    public static void main(String[] args) {
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        int[] arr = {4,2,3,5,7,5,9,7};
        System.out.println(nonDecreasingArray.checkPossibility(arr));
    }
}
