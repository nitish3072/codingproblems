package scaler.searching_1_binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedInsertPosition {

    public static void main(String[] args) {
        int[] ints = new int[]{ 1, 3, 5, 6};
        SortedInsertPosition sortedInsertPosition = new SortedInsertPosition();
        System.out.println(sortedInsertPosition.searchInsert(Arrays.stream(ints).boxed().collect(Collectors.toList()), 7));
    }

    public int searchInsert(List<Integer> A, int B) {
        int s = 0, e = A.size() - 1, mid = 0;
        while (s <= e) {
            mid = (s + e) / 2;
            if (A.get(mid) == B) {
                return mid;
            } else if (A.get(mid) > B) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        if(s == A.size()) return A.size();
        else return s;
    }

}
