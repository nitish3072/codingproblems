package leetcode.medium;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstandLastPositionElementSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[1] = findFirst(nums, target);
        result[0] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int result = -1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (j + i) / 2;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[(j + i) / 2] <= target) {
                i = mid + 1;
            }
            if (nums[mid] == target) result = mid;
        }
        return result;
    }

    private int findLast(int[] nums, int target) {
        int result = -1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (j + i) / 2;
            if (nums[mid] >= target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            }
            if (nums[mid] == target) result = mid;
        }
        return result;
    }

    public static void main(String[] args) {
        FindFirstandLastPositionElementSortedArray findFirstandLastPositionElementSortedArray = new FindFirstandLastPositionElementSortedArray();
        int[] arr = {5, 7, 7, 8, 8, 10};
        findFirstandLastPositionElementSortedArray.searchRange(arr, 6);
    }

}
