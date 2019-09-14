import java.util.Arrays;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/inversion-of-array/0/
 */

// Use normal array of Integers and start sorting it from Left to Right. No keep replacing the smallest element in the right of the sorted array with the current index of the counter.
public class InversionOfArray {
    static int smallestIndex = 0;
    static int smallest = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        sc.nextLine();
        while (testCases>0) {
            testCases--;
            int result = 0;
            Integer[] strs = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
            for(int i = 0; i<strs.length-1;i++) {
                indexOfSmallestInteger(strs, i+1);
                if(strs[smallestIndex]<strs[i]) {
                    swapElements(strs, i, smallestIndex);
                    result++;
                }
            }
            System.out.println(result);
            Arrays.stream(strs).forEach(t-> System.out.print(t+" "));
        }
    }

    private static int indexOfSmallestInteger(Integer[] list, int startIndex) {
        smallestIndex = startIndex;
        smallest = list[startIndex];
        for(int i = startIndex; i<list.length; i++) {
            if(list[i]<smallest) {
                smallest = list[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    private static void swapElements(Integer[] list, int indexOfOriginalElem, int indexOfElementToSwap) {
        int temp = list[indexOfOriginalElem];
        list[indexOfOriginalElem] = list[indexOfElementToSwap];
        list[indexOfElementToSwap] = temp;
    }

}
