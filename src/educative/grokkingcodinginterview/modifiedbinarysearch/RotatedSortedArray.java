package educative.grokkingcodinginterview.modifiedbinarysearch;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArray {

    public static int binarySearchRotated(List<Integer> nums, int target) {
        int n = nums.size();
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums.get(mid) > nums.get(hi)) lo = mid + 1;
            else hi = mid;
        }
        int rot = lo;
        lo = 0;
        hi = n - 1;
        while (lo <= hi) {
            int mid = (hi + lo) / 2;
            int actualMid = (mid + rot) > n-1 ? (mid + rot) - (n-1) : (mid + rot);
            if (target == nums.get(actualMid)) return actualMid;
            if (target == nums.get(hi)) return hi;
            if (target == nums.get(lo)) return lo;
            if (target > nums.get(actualMid)) lo = mid + 1;
            else hi = mid-1;
        }
        return -1;
    }

    public static void main(String args[]) {
        List < Integer > targetList = Arrays.asList(3, 3, 6, 3, 6);
        List < List < Integer >> numList = Arrays.asList(Arrays.asList(6, 7, 1, 2, 3, 4, 5), Arrays.asList(1,3), Arrays.asList(6, 7, 1, 2, 3, 4, 5), Arrays.asList(4, 5, 6, 1, 2, 3), Arrays.asList(4, 5, 6, 1, 2, 3));
        for (int i = 0; i < targetList.size(); i++) {
            System.out.println((i + 1) + ".\tSorted array: " + numList.get(i) + "\n\ttarget " + targetList.get(i) + " found at index " + binarySearchRotated(numList.get(i), targetList.get(i)));
        }
    }
}
