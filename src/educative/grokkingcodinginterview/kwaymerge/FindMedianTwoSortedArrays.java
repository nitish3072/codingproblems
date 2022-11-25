package educative.grokkingcodinginterview.kwaymerge;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianTwoSortedArrays {

    public static double findMedian(int[] nums1, int[] nums2) {
        PriorityQueue<int[]> pq1 = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        if(nums1.length != 0) pq1.add(new int[]{nums1[0], 0, 1});
        if(nums2.length != 0) pq1.add(new int[]{nums2[0], 0, 2});
        int[] result = new int[2];
        for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
            int[] element = pq1.poll();
            if (element[2] == 1 && element[1] + 1 < nums1.length) {
                pq1.add(new int[]{nums1[element[1] + 1], element[1] + 1, 1});
            } else if (element[2] == 2 && element[1] + 1 < nums2.length) {
                pq1.add(new int[]{nums2[element[1] + 1], element[1] + 1, 2});
            }
            result[0] = result[1];
            result[1] = element[0];
        }
        return (nums1.length+nums2.length)%2==0 && nums1.length+nums2.length>1 ?((double)result[0] + result[1])/2 : result[1];
    }

    public static void main(String[] args) {
        int[] i = new int[] {};
        int[] i1 = new int[] {1};
        System.out.println(findMedian(i, i1));
    }

}
