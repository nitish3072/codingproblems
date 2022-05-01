package leetcode.april.easy;

/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        return search(nums, 0, nums.length, target);
    }

    public int search(int[] a, int start, int end, int target) {
        if(start==end) return start;
        int mid = (start + end)/2;
        if(a[mid] == target) return mid;
        if(a[mid] > target) return search(a, start, mid, target);
        else return search(a, mid+1, end, target);
    }

    public static void main(String[] args) {
        int[] a = {1,3,5,6};
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        System.out.println(searchInsertPosition.searchInsert(a, 5));
    }

}
