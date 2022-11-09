package educative.grokkingcodinginterview.twopointer;

import java.util.ArrayList;
import java.util.List;

public class SubarrayProductLessThanK {

    public static int findSubarrays(int[] arr, int target) {
        int finalCount = 0;
        int windowStart = 0;
        int currentProduct = 1;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            currentProduct = currentProduct * arr[windowEnd];
            while (windowStart <= windowEnd && currentProduct >= target) {
                currentProduct = currentProduct / arr[windowStart];
                windowStart++;
            }
            finalCount = finalCount + (windowEnd - windowStart + 1);
        }
        return finalCount;
    }

    public static List<List<Integer>> findSubarrays1(int[] arr, int target) {
        List<List<Integer>> subarrays = new ArrayList<>();
        for (int j = 0; j < arr.length; j++) {
            subarray(subarrays, arr, target, 1, new ArrayList<>(), j);
        }
        return subarrays;
    }

    public static void subarray(List<List<Integer>> subarrays,
                                int[] arr,
                                int target,
                                int currentProduct,
                                List<Integer> currentList,
                                int ptr) {
        if (ptr >= arr.length) {
            return;
        }
        if (currentProduct * arr[ptr] < target) {
            currentList.add(arr[ptr]);
            subarrays.add(new ArrayList<>(currentList));
            currentProduct = currentProduct * arr[ptr];
        }  else {
            return;
        }
        subarray(subarrays, arr, target, currentProduct, currentList, ptr + 1);
    }

    public static void main(String[] args) {
        System.out.println(SubarrayProductLessThanK.findSubarrays1(new int[]{2, 5, 3, 10}, 30));
        System.out.println(SubarrayProductLessThanK.findSubarrays1(new int[]{8, 2, 6, 5}, 50));
        System.out.println(SubarrayProductLessThanK.findSubarrays1(new int[]{10, 9, 10, 4, 3, 8, 3, 3, 6, 2, 10, 10, 9, 3}, 19));
    }

}
