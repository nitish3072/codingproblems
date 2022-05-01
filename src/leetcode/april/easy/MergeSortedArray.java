package leetcode.april.easy;


/**
 * https://leetcode.com/problems/merge-sorted-array/
 * https://leetcode.com/problems/merge-sorted-array/discuss/1994483/Clean-Java-solution-with-explanation
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int num1Ptr = m - 1;
        int num2Ptr = n - 1;
        int indexFromLast = m+n-1;
        while (num1Ptr >= 0 && num2Ptr >= 0) {
            nums1[indexFromLast--] = (nums1[num1Ptr] > nums2[num2Ptr]) ? nums1[num1Ptr--] : nums2[num2Ptr--];
        }

        while (num2Ptr >= 0) {
            nums1[indexFromLast--] = nums2[num2Ptr--];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(num1, 3, num2, 3);
    }

}
