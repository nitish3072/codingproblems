package leetcode.medium;

/**
 * https://leetcode.com/problems/sort-colors/submissions/
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int i=0, j=nums.length-1, index=0;
        while (index <= j) {
            if(nums[index]==0) {
                nums[index] = nums[i];
                nums[i] = 0;
                i++;
            }
            if(nums[index]==2) {
                nums[index] = nums[j];
                nums[j] = 2;
                j--;
                index--;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();
        int[] arr = {2,0,1};
        sortColors.sortColors(arr);
    }

}
