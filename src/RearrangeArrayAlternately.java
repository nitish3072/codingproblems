import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately/0/
 */

public class RearrangeArrayAlternately {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases>0) {
            testCases--;
            int size = sc.nextInt();
            sc.nextLine();
            LinkedList<Integer> strs = Arrays.stream(sc.nextLine().split(" ")).map(Integer::valueOf)
                    .collect(Collectors.toCollection(LinkedList::new));
            for(int i=0;i<strs.size();i=i+2) {
                changeLastElementToIndex(strs, i);
            }
            strs.forEach(t-> System.out.print(t+" "));
            System.out.println();
        }
    }

    public static void changeLastElementToIndex(LinkedList<Integer> list, int index) {
        list.add(index, list.getLast());
        list.remove(list.size()-1);
    }
}
