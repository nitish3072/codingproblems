package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pickfrombothsides {

    public int solve(List<Integer> A, int B) {
        int maxSum = Integer.MIN_VALUE;
        int sumright = 0;

        // Take right sum
        for (int i = A.size() - B; i < A.size(); i++) {
            sumright = sumright + A.get(i);
        }
        int sumleft = 0;

        // Take Left sum
        for (int i = 0; i < B; i++) {
            sumleft = sumleft + A.get(i);
        }
        maxSum = Math.max(sumleft, sumright);
        int left = 0;
        int right = A.size() - B + 1;

        // Now move the window from back to front as in a cyclic manner and keep calculating sum of the window
        while (right < A.size()) {
            sumright = sumright + A.get(left) - A.get(right - 1);
            maxSum = Math.max(maxSum, sumright);
            left++;
            right++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] ints = new int[] {5, -2, 3 , 1, 2};
        Pickfrombothsides pickfrombothsides = new Pickfrombothsides();
        System.out.println(pickfrombothsides.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 3));
    }

}
