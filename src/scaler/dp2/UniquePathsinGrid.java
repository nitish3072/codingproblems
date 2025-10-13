package scaler.dp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePathsinGrid {

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> A) {
        int[][] dp = new int[A.size()][A.get(0).size()];
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i).get(0) == 1) break;
            dp[i][0] = 1;
        }
        for (int j = 0; j < A.get(0).size(); j++) {
            if (A.get(0).get(j) == 1) break;
            dp[0][j] = 1;
        }

        for (int i = 1; i < A.size(); i++) {
            for (int j = 1; j < A.get(i).size(); j++) {
                if(A.get(i).get(j) == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[A.size()-1][A.get(0).size()-1];
    }

    public static void main(String[] args) {
        UniquePathsinGrid u = new UniquePathsinGrid();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(0, 0)));
        A.add(new ArrayList<>(List.of(0, 0)));
        A.add(new ArrayList<>(List.of(0, 0)));
        A.add(new ArrayList<>(List.of(1, 0)));
        A.add(new ArrayList<>(List.of(0, 0)));
        System.out.println(u.uniquePathsWithObstacles(A));
    }

}
