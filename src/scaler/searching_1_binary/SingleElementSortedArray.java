package scaler.searching_1_binary;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SingleElementSortedArray {

    public int solve(List<Integer> A) {
        int s = 0, e = A.size() - 1, mid = 0;
        while (s <= e) {
            mid = (s + e) / 2;
            if (mid == 0 || mid == A.size() - 1) return A.get(mid);
            if (!Objects.equals(A.get(mid), A.get(mid - 1)) && !Objects.equals(A.get(mid), A.get(mid + 1))) {
                return A.get(mid);
            } else if (Objects.equals(A.get(mid), A.get(mid - 1))) {
                if ((mid - 1) % 2 == 0) s = mid + 1;
                else e = mid - 1;
            } else if (Objects.equals(A.get(mid), A.get(mid + 1))) {
                if ((mid) % 2 == 0) s = mid + 1;
                else e = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 1, 2,2,3,4,4,5,5,6,6};
        SingleElementSortedArray sortedInsertPosition = new SingleElementSortedArray();
        System.out.println(sortedInsertPosition.solve(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }

}
