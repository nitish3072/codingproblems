package educative.grokkingcodinginterview.kwaymerge;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MergeSorted {

    public static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {

        // Write your code here
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        while (p >= 0 && p1 >= 0) {
            nums1[p--] = nums1[p1--];
        }
        while (p >= 0 && p2 >= 0) {
            nums1[p--] = nums2[p2--];
        }
        return nums1;
    }

    public static void main(String args[]) {
        int[] m = {9, 2, 3, 1, 8};
        int[] n = {6, 1, 4, 2, 1};
        int[][] nums1 = {
                {23, 33, 35, 41, 44, 47, 56, 91, 105, 0, 0, 0, 0, 0, 0},
                {1, 2, 0},
                {1, 1, 1, 0, 0, 0, 0},
                {6, 0, 0},
                {12, 34, 45, 56, 67, 78, 89, 99, 0}
        };
        int[][] nums2 = {
                {32, 49, 50, 51, 61, 99},
                {7},
                {1, 2, 3, 4},
                {-99, -45},
                {100}
        };
        int k = 1;
        for (int i = 0; i < m.length; i++) {
            System.out.print(k + ".\tnums1: [");
            for (int j = 0; j < nums1[i].length - 1; j++) {
                System.out.print(nums1[i][j] + ", ");
            }
            System.out.println(nums1[i][nums1[i].length - 1] + "], m: " + m[i]);
            System.out.print("\tnums2: [");
            for (int j = 0; j < nums2[i].length - 1; j++) {
                System.out.print(nums2[i][j] + ", ");
            }
            System.out.println(nums2[i][nums2[i].length - 1] + "], n: " + n[i]);
            int[] result = mergeSorted(nums1[i], m[i], nums2[i], n[i]);
            System.out.println("\tMerged list: " + result);
            k += 1;
        }
    }

}
