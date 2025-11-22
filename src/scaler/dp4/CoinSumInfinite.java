package scaler.dp4;

import java.util.ArrayList;
import java.util.List;

public class CoinSumInfinite {

    public int coinchange2(ArrayList<Integer> A, int B) {
        int[] dp = new int[B + 1];
        dp[0] = 1;
        for (int i = 0; i < A.size(); i++) {
            for (int sum = 1; sum <= B; sum++) {
                if (sum >= A.get(i)) {
                    dp[sum] += (dp[sum - A.get(i)]) % 1000007;
                }
            }
        }
        return dp[B] % 1000007;
    }

    public static void main(String[] args) {
        CoinSumInfinite coin = new CoinSumInfinite();
        ArrayList<Integer> A = new ArrayList<>(List.of(1, 2, 3));
        System.out.println(coin.coinchange2(A, 4));
    }

}
