package scaler.two_pointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ThreeSum {

    public int threeSumClosest(List<Integer> A, int B) {
        Collections.sort(A);
        int ans = Integer.MIN_VALUE;
        for (int h = 0; h < A.size(); h++) {
            int i = h + 1, j = A.size() - 1;
            while (i < j) {
                if (A.get(j) + A.get(i) > B - A.get(h)) {
                    ans = Math.abs(A.get(j) + A.get(i) - B + A.get(h)) < Math.abs(ans - B) ? A.get(j) + A.get(i) + A.get(h) : ans;
                    j--;
                } else if (A.get(j) + A.get(i) < B - A.get(h)) {
                    ans = Math.abs(A.get(j) + A.get(i) + A.get(h) - B) < Math.abs(ans - B) ? A.get(j) + A.get(i) + A.get(h) : ans;
                    i++;
                } else return B;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{-1, 2, 1, -4};
        ThreeSum sortedInsertPosition = new ThreeSum();
        System.out.println(sortedInsertPosition.threeSumClosest(Arrays.stream(ints).boxed().collect(Collectors.toList()), 1));
    }

}
