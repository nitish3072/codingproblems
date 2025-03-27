package scaler.searching_3_binary;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AllocateBooks {

    public int books(List<Integer> A, int B) {
        if(B > A.size()) return -1;
        int s = Collections.max(A), e = A.stream().mapToInt(Integer::intValue).sum(), mid = 0, ans = -1;
        while (s <= e) {
            mid = s + ((e - s) / 2);
            int students = isPossible(A, B, mid);
            if (students <= B) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    private int isPossible(List<Integer> A, int B, int mid) {
        int students = 1;
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (sum > mid) {
                sum = A.get(i);
                students++;
            }
        }
        return students;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{31,14,19,75};
        AllocateBooks sortedInsertPosition = new AllocateBooks();
        System.out.println(sortedInsertPosition.books(Arrays.stream(ints).boxed().collect(Collectors.toList()), 12));
    }

}
