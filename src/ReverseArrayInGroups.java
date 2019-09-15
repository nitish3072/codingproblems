import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/reverse-array-in-groups/0
 */

public class ReverseArrayInGroups {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        while (testCases > 0) {
            String nk = sc.nextLine();
            String size = nk.split(" ")[0];
            Integer k = Integer.valueOf(nk.split(" ")[1]);
            testCases--;
            BigInteger[] array = Arrays.stream(sc.nextLine().split(" ")).map(BigInteger::new).toArray(BigInteger[]::new);

            int index = 0;
            while (index<array.length){
                if((index+k)>=array.length) {
                    reverseArray(array, index, array.length);
                } else {
                    reverseArray(array, index, index + k);
                }
                index = index + k;
            }
            Arrays.stream(array).forEach(t -> System.out.print(t+" "));
            System.out.println();
        }
    }

     public class ListNode {
      int val;
 ListNode next;
      ListNode(int x) { val = x; }
  }
    /**
     *
     * @param array array to be modified
     * @param fromIndex Inclusive
     * @param toIndex Not inclusive
     */
    public static void reverseArray(BigInteger[] array, int fromIndex, int toIndex) {
        for(int i =fromIndex;i<fromIndex + (toIndex-fromIndex)/2;i++) {
            BigInteger temp = array[i];
            array[i] = array[toIndex-1];
            array[toIndex-1] = temp;
        }
    }
}
