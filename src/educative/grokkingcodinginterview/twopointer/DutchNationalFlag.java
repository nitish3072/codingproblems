package educative.grokkingcodinginterview.twopointer;

import java.util.Arrays;

public class DutchNationalFlag {

    public static void sort(int[] arr) {
        rearrangeArray(rearrangeArray(rearrangeArray(0, 0, arr), 1, arr), 2, arr);
    }

    public static int rearrangeArray(int windowStart, int flagNumber, int[] arr) {
        for(int windowEnd = windowStart; windowEnd < arr.length; windowEnd++) {
            if(arr[windowEnd] == flagNumber) {
                swap(arr, windowStart, windowEnd);
                windowStart++;
            }
        }
        return windowStart;
    }

    public static void swap(int[] arr, int leftI, int rightI) {
        int temp = arr[leftI];
        arr[leftI] = arr[rightI];
        arr[rightI] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 0, 2, 1, 0 };
        DutchNationalFlag.sort(arr);
        System.out.print(Arrays.toString(arr));

        System.out.println();

        arr = new int[] { 2, 2, 0, 1, 2, 0 };
        DutchNationalFlag.sort(arr);
        System.out.print(Arrays.toString(arr));
    }

}
