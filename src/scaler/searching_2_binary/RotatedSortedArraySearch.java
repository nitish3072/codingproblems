package scaler.searching_2_binary;

import scaler.searching_1_binary.SingleElementSortedArray;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotatedSortedArraySearch {

    public int search(final List<Integer> A, int target) {
        int s = 0, e = A.size() - 1, mid = 0, index = -1;
        while (s <= e) {
            mid = (s + e) / 2;
            if (A.get(mid) == target) {
                index = mid;
                break;
            } else if((target >= A.get(0) && A.get(mid) > A.get(0)) || (target < A.get(0) && A.get(mid) < A.get(0))) {
                if (A.get(mid) > target) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else if (target >= A.get(0) && A.get(mid) < A.get(0)) {
                e = mid - 1;
            } else if (target < A.get(0) && A.get(mid) > A.get(0)) {
                s = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{4, 5, 6, 7, 0, 1, 2, 3};
        RotatedSortedArraySearch sortedInsertPosition = new RotatedSortedArraySearch();
        System.out.println(sortedInsertPosition.search(Arrays.stream(ints).boxed().collect(Collectors.toList()), 4));
    }

}
