package scaler.dp1;

public class Stairs {

    int[] dp;
    public int climbStairs(int A) {
        dp = new int[A+1];
        return stairsProblem(A);
    }

    public int stairsProblem(int A) {
        if(A <= 2) return A;
        if(dp[A] != 0) return dp[A];
        dp[A] = (stairsProblem(A-1) + stairsProblem(A-2)) % (10^9+7);
        return dp[A];
    }

    public static void main(String[] args) {
        Stairs s = new Stairs();
        System.out.println(s.climbStairs(8));
    }

}
