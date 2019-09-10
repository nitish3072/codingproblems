import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays/0/
 */

public class MergeSortedArrays {

    public static void main(String[] args) {
        Scanner sc = new java.util.Scanner(System.in);
        int totalCases = sc.nextInt();
        sc.nextLine();
        while (totalCases>0) {
            sc.nextLine();
            String[] first = sc.nextLine().split(" ");
            String[] second = sc.nextLine().split(" ");
            List<Integer> firstList = new LinkedList<>();
            List<Integer> secondList = new LinkedList<>();
            for(String l: first) {firstList.add(Integer.valueOf(l));}
            for(String l: second) {secondList.add(Integer.valueOf(l));}
            int i = 0;
            int j = 0;
            while (i<firstList.size()) {
                if(j>=secondList.size()) {
                    secondList.add(j, firstList.get(i));
                    i++;
                    j++;
                } else if(firstList.get(i)<=secondList.get(j)) {
                    j++;
                } else {
                    secondList.add(j, firstList.get(i));
                    i++;
                    j++;
                }
            }
            totalCases--;
            secondList.stream().map(t -> t + " ").forEach(System.out::print);
            System.out.println();
        }

    }
}