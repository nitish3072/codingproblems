import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0
 */

public class SortAnArrayOf0s1sAnd2s {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();
        while (testCases>0) {
            sc.nextLine();
            testCases--;
            Map<Integer, Integer> countOfNumbers = new HashMap<>();
            countOfNumbers.put(0, 0);
            countOfNumbers.put(1, 0);
            countOfNumbers.put(2, 0);
            Integer[] strs = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf).toArray(Integer[]::new);
            for(Integer string: strs) {
                for(Integer number: countOfNumbers.keySet()) {
                    if(number.equals(string)) {
                        countOfNumbers.put(number, countOfNumbers.get(number)+1);
                        break;
                    }
                }
            }
            for(Integer number: countOfNumbers.keySet()) {
                for(int i = 0; i<countOfNumbers.get(number);i++) {
                    System.out.print(number+ " ");
                }
            }
            System.out.println();
        }
    }
}
