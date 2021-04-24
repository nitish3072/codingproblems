package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pancake-sorting/submissions/
 */
public class PancakeSorting {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> listOfFlips = new ArrayList<>();
        for(int i=arr.length-1;i>=1;i--) {
            int maxIndex = findMaxIndex(0, i+1, arr);
            arr = flip(maxIndex + 1, arr);
            listOfFlips.add(maxIndex + 1);
            arr = flip(i + 1, arr);
            listOfFlips.add(i + 1);
        }
        return listOfFlips;
    }

    // Not including j index
    public int findMaxIndex(int i, int j, int[] arr) {
        int maxIndex = 0;
        for(int k=i;k<j;k++) {
            if(arr[k] > arr[maxIndex]) {
                maxIndex = k;
            }
        }
        return maxIndex;
    }

    // Not including i index
    public int[] flip(int i, int[] arr) {
        int k=0;
        i = i-1;
        while (i > k) {
            int temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
            i--;k++;
        }
        return arr;
    }

    public static void main(String[] args) {
        PancakeSorting pancakeSorting = new PancakeSorting();
        int[] arr = {3,2,4,1};
        pancakeSorting.pancakeSort(arr).forEach(System.out::println);
    }

}
