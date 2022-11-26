package educative.grokkingcodinginterview.topkelements;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k = 0;
    // constructor to initialize topKHeap and add values in it
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        pq.add(val);
        while (pq.size()>this.k) pq.poll();
        return returnKthLargest();
    }

    public int returnKthLargest() {
        if(pq.isEmpty()) return -1;
        return pq.peek();
    }

    public static void main(String args[]) {
        int[] nums = { 3, 6, 9, 10 };
        int[] temp = { 3, 6, 9, 10 };
        System.out.println("Initial stream: " + Arrays.toString(nums));
        KthLargest kLargest = new KthLargest(3, nums);
        int[] val = { 4, 7, 10, 8, 15 };
        System.out.println();
        for (int i = 0; i<val.length; i++) {
            System.out.println("\tAdding a new number " + val[i] + " to the stream");
            temp = Arrays.copyOf(temp, temp.length + 1);
            temp[temp.length - 1] = val[i];
            System.out.println("\t\tNumber stream: " + Arrays.toString(temp));
            System.out.println("\tKth largest element in the stream: " + kLargest.add(val[i]));
        }
    }

}
