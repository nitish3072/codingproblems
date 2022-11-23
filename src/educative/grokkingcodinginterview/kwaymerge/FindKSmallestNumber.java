package educative.grokkingcodinginterview.kwaymerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKSmallestNumber {

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (Integer[] list : lists) {
            for (int i = 0; i < k && i < list.length; i++) {
                pq.add(list[i]);
            }
        }
        if(pq.size()<k) return 0;
        int result = 0;
        for (int i = 0; i < k; i++) {
            result = pq.poll();
        }
        return result;

    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 1,5,9 };
        Integer[] l2 = new Integer[] {10,11,13 };
        Integer[] l3 = new Integer[] {12,13,15};
        int k = 8;
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        System.out.println("1.\tInput lists: ["+ Arrays.toString(lists.get(0))+Arrays.toString(lists.get(1))+Arrays.toString(lists.get(2)) + "]");
        int result = FindKSmallestNumber.findKthSmallest(lists, k);
        System.out.println("\tK: "+ k);
        System.out.println("\t" + k+ "th smallest number from the lists is: " + result);

        // 2nd
        Integer[] l11 = new Integer[] { 1, 2, 3};
        Integer[] l21 = new Integer[] { 4, 5};
        Integer[] l31 = new Integer[] {6, 7, 8, 15};
        Integer[] l41 = new Integer[] {10, 11, 12, 13};
        Integer[] l51 = new Integer[] {5, 10};

        k = 50;
        List<Integer[]> lists1 = new ArrayList<Integer[]>();
        lists1.add(l11);
        lists1.add(l21);
        lists1.add(l31);
        lists1.add(l41);
        lists1.add(l51);
        System.out.println("2.\tInput lists: ["+Arrays.toString(lists1.get(0))+Arrays.toString(lists1.get(1))+Arrays.toString(lists1.get(2))+Arrays.toString(lists1.get(3))+ Arrays.toString(lists1.get(4)) + "]");
        result = FindKSmallestNumber.findKthSmallest(lists1, k);
        System.out.println("\tK: "+ k);
        System.out.println("\t" + k+ "th smallest number from the lists is: " + result);

        // 3rd
        Integer[] l111 = new Integer[] {};
        Integer[] l211 = new Integer[] {};
        Integer[] l311 = new Integer[] {};

        k = 4;
        List<Integer[]> lists2 = new ArrayList<Integer[]>();
        lists2.add(l111);
        lists2.add(l211);
        lists2.add(l311);
        System.out.println("3.\tInput lists: ["+Arrays.toString(lists2.get(0))+Arrays.toString(lists2.get(1))+Arrays.toString(lists2.get(2))+ "]");
        result = FindKSmallestNumber.findKthSmallest(lists2, k);
        System.out.println("\tK: "+ k);
        System.out.println("\t" + k+ "th smallest number from the lists is: " + result);

        // 4th
        Integer[] l1111 = new Integer[] {1, 1, 3, 8};
        Integer[] l2111 = new Integer[] {5, 5, 7, 9};
        Integer[] l3111 = new Integer[] {3, 5, 8, 12};

        k = 4;
        List<Integer[]> lists3 = new ArrayList<Integer[]>();
        lists3.add(l1111);
        lists3.add(l2111);
        lists3.add(l3111);
        System.out.println("4.\tInput lists: ["+Arrays.toString(lists3.get(0))+Arrays.toString(lists3.get(1))+Arrays.toString(lists3.get(2))+ "]");
        result = FindKSmallestNumber.findKthSmallest(lists3, k);
        System.out.println("\tK: "+ k);
        System.out.println("\t" + k+ "th smallest number from the lists is: " + result);

        // 5th
        Integer[] l11111 = new Integer[] {5, 8, 9, 17};
        Integer[] l21111 = new Integer[] { };
        Integer[] l31111 = new Integer[] {21, 22, 23, 24};

        k = 8;
        List<Integer[]> lists4 = new ArrayList<Integer[]>();
        lists4.add(l11111);
        lists4.add(l21111);
        lists4.add(l31111);
        System.out.println("5.\tInput lists: ["+Arrays.toString(lists4.get(0))+Arrays.toString(lists4.get(1))+Arrays.toString(lists4.get(2))+ "]");
        result = FindKSmallestNumber.findKthSmallest(lists4, k);
        System.out.println("\tK: "+ k);
        System.out.println("\t" + k+ "th smallest number from the lists is: " + result);

    }
}
