package algoxpert.arrays;

import java.util.*;

/**
 * https://www.algoexpert.io/questions/two-number-sum
 */
public class TwoNumberSumEasy {

    public static int[] twoNumberSum(int[] a, int targetSum) {
        int[][] arr = new int[a.length][2];
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            arr[i][0] = i;
            arr[i][1] = num;
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));
        int start = 0, end = a.length - 1;
        while (start < end) {
            if(arr[start][1] + arr[end][1] == targetSum) {
                int[] result = new int[2];
                result[0] = arr[start][0];
                result[1] = arr[end][0];
                return result;
            } else if(arr[start][1] + arr[end][1]  > targetSum) {
                end--;
            } else {
                start++;
            }
        }
        return new int[0];
    }


}
