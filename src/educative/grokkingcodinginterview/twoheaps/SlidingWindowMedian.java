package educative.grokkingcodinginterview.twoheaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class SlidingWindowMedian {
    public static double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a - b;
        TreeSet<Integer> maxSet = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> minSet = new TreeSet<>(comparator);
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < k; i++) maxSet.add(i);
        reBalance(maxSet, minSet);
        result[0] = getMedian(maxSet, minSet, nums, k);
        for (int i = k; i < nums.length; i++) {
            maxSet.remove(i - k);
            minSet.remove(i -k);
            minSet.add(i);
            maxSet.add(minSet.pollFirst());
            reBalance(maxSet, minSet);
            result[i - k + 1] = getMedian(maxSet, minSet, nums, k);
        }
        return result;
    }

    public static void reBalance(TreeSet<Integer> maxSet,TreeSet<Integer> minSet) {
        while (maxSet.size() > minSet.size()) minSet.add(maxSet.pollFirst());
    }

    public static double getMedian(TreeSet<Integer> maxSet,TreeSet<Integer> minSet, int[] nums, int k) {
        if (k % 2 == 0) {
            return ((double)nums[minSet.first()] + nums[maxSet.first()]) / 2;
        } else {
            return nums[minSet.first()];
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, -1, -3, 5, 3, 6, 7}, {1, 2}, {4, 7, 2, 21}, {22, 23, 24, 56, 76, 43, 121, 1, 2, 0, 0, 2, 3, 5}, {1, 1, 1, 1, 1}};
        int[] k = {3, 1, 2, 5, 2};
        for (int i = 0; i < k.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput array = " + Arrays.toString(arr[i]) + ", k = " + k[i]);
            double[] output = medianSlidingWindow(arr[i], k[i]);
            System.out.println("\tMedians =" + Arrays.toString(output));
        }
    }

}
