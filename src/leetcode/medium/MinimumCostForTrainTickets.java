package leetcode.medium;

public class MinimumCostForTrainTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int[][] dp = new int[costs.length][days.length];
        for(int i=0; i<days.length; i++) {
            dp[0][i] = (i-1 < 0 ? 0 : dp[0][i-1]) + costs[0];
        }
        int sevenDayWindow = 0;
        for(int i=0; i<days.length; i++) {
            while (days[i] - days[sevenDayWindow] > 7-1) {
                sevenDayWindow++;
            }
            dp[1][i] = Math.min((i-1 < 0 ? 0 : dp[1][i-1]) + costs[0], Math.min((sevenDayWindow-1 < 0 ? 0 : dp[1][sevenDayWindow-1]) + costs[1], dp[0][i]));
        }
        sevenDayWindow = 0;
        int fifteenDayWindow = 0;
        for(int i=0; i<days.length; i++) {
            while (days[i] - days[sevenDayWindow] > 7-1) {
                sevenDayWindow++;
            }
            while (days[i] - days[fifteenDayWindow] > 30-1) {
                fifteenDayWindow++;
            }
            dp[2][i] = Math.min((i-1 < 0 ? 0 : dp[2][i-1]) + costs[0], Math.min((sevenDayWindow-1 < 0 ? 0 : dp[2][sevenDayWindow-1]) + costs[1], Math.min((fifteenDayWindow-1 < 0 ? 0 : dp[2][fifteenDayWindow-1]) + costs[2], dp[1][i])));
        }
        return dp[2][days.length-1];
    }

//    public int mincostTickets(int[] days, int[] costs) {
//        boolean[] dayIncluded = new boolean[366];
//        for (int day : days) {
//            dayIncluded[day] = true;
//        }
//        int[] minCost = new int[366];
//        minCost[0] = 0;
//        for (int day = 1; day <= 365; ++day) {
//            if (!dayIncluded[day]) {
//                minCost[day] = minCost[day-1];
//                continue;
//            }
//            int min;
//            min = minCost[day-1] + costs[0];
//            min =Math.min(min, minCost[Math.max(0, day-7)] + costs[1]);
//            min = Math.min(min, minCost[Math.max(0, day-30)] + costs[2]);
//            minCost[day] = min;
//        }
//
//        return minCost[365];
//
//    }

    public static void main(String[] args) {
        MinimumCostForTrainTickets minimumCostForTrainTickets = new MinimumCostForTrainTickets();
        int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
        System.out.println(minimumCostForTrainTickets.mincostTickets(days, costs));
    }
}
