package scaler.dp2;

import java.util.ArrayList;
import java.util.List;

public class MaxSumWithoutAdjacentElements {

    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        int[] dp = new int[A.get(0).size() + 1];
        dp[1] = Math.max(A.get(1).get(0), A.get(0).get(0));
        for (int i = 2; i < A.get(0).size() + 1; i++) {
            int arrayElement = Math.max(A.get(1).get(i -1), A.get(0).get(i -1));
            dp[i] = Math.max(dp[i - 1], arrayElement + dp[i - 2]);
        }
        return dp[A.get(0).size()];
    }

    public static void main(String[] args) {
        MaxSumWithoutAdjacentElements sol = new MaxSumWithoutAdjacentElements();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(16, 5, 54, 55, 36, 82, 61, 77, 66, 61)));
        A.add(new ArrayList<>(List.of(31, 30, 36, 70, 9, 37, 1, 11, 68, 14)));
        System.out.println(sol.adjacent(A));
    }

}
