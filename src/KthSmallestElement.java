import helpers.Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://practice.geeksforgeeks.org/problems/kth-smallest-element/0
 */

public class KthSmallestElement {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-->0) {
            int size = Integer.valueOf(reader.readLine());
            String[] strs = reader.readLine().trim().split(" ");
            int[] arr = new int[size];
            for(int i =0;i<size;i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }
            int k = Integer.valueOf(reader.readLine());
            Heap heap = new Heap(size);
            Arrays.stream(arr).forEach(heap::addElement);
            while (k-->1) {
                heap.removeElement(0);
            }
            System.out.println(heap.topElement());
        }
    }

}
