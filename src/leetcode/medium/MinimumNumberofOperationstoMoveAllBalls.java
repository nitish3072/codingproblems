package leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 */
public class MinimumNumberofOperationstoMoveAllBalls {

    public int[] minOperations1(String boxes) {
        int[] dp = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            dp[i] = 0;
            for (int j = 0; j < boxes.length(); j++) {
                int numberAtJ = Integer.parseInt(String.valueOf(boxes.charAt(j)));
                if(numberAtJ==1) {
                    dp[i] = dp[i] + Math.abs(numberAtJ * (j-i));
                }
            }
        }
        return dp;
    }

    //Better solution
    public int[] minOperations(String boxes) {
        int numberOfOnes = 0;
        int[] dp = new int[boxes.length()];
        dp[0] = 0;
        for (int i = 0; i < boxes.length(); i++) {
            int numberAtI = Integer.parseInt(String.valueOf(boxes.charAt(i)));
            if(numberAtI==1) {
                dp[0] = dp[0] + i;
                numberOfOnes = numberOfOnes + 1;
            }
        }
        int numberOfOnesWentBy = Integer.parseInt(String.valueOf(boxes.charAt(0))) == 1 ? 1 : 0;
        for (int i = 1; i < boxes.length(); i++) {
            int numberAtI = Integer.parseInt(String.valueOf(boxes.charAt(i)));
            dp[i] = dp[i-1] - (numberOfOnes - numberOfOnesWentBy) + numberOfOnesWentBy ;
            if(numberAtI==1) {
                numberOfOnesWentBy = numberOfOnesWentBy + 1;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        MinimumNumberofOperationstoMoveAllBalls minimumNumberofOperationstoMoveAllBalls = new MinimumNumberofOperationstoMoveAllBalls();
        System.out.println(Arrays.toString(minimumNumberofOperationstoMoveAllBalls.minOperations("110")));
    }

}
