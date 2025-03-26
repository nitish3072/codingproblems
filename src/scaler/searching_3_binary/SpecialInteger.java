package scaler.searching_3_binary;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpecialInteger {

    public int solve(List<Integer> A, int B) {
        int s = 1, e = A.size(), mid = 0, ans = 0;
        while (s <= e) {
            mid = s + ((e - s) / 2);
            if (isPossible(A, B, mid)) {
                s = mid + 1;
                ans = mid;
            } else {
                e = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(List<Integer> A, int B, int mid) {
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            if (i < mid) {
                sum += A.get(i);
            } else {
                sum -= A.get(i - mid);
                sum += A.get(i);
            }
            if (sum > B) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 4, 5, 100};
        SpecialInteger sortedInsertPosition = new SpecialInteger();
        System.out.println(sortedInsertPosition.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 10));
    }
}
