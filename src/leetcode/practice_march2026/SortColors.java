package leetcode.practice_march2026;

public class SortColors {

    public void sortColors(int[] nums) {
        int p0 = 0, curr = 0, p2 = nums.length - 1;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                swap(nums, curr, p0);
                p0++;
                curr++;
            } else if (nums[curr] == 2) {
                swap(nums, curr, p2);
                p2--;
            } else {
                curr++;
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}
