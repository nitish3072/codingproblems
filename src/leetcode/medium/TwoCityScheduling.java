package leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-city-scheduling/
 */
public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> (o1[1]-o1[0]) - (o2[1]-o2[0]));
        int sum = 0;
        for(int i=0, j=costs.length-1; i<j; i++, j--) {
            sum += costs[i][1] + costs[j][0];
        }
        return sum;
    }

    public static void main(String[] args) {
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
        int[][] arr = {{10,20},{30,200},{400,50},{30,20}};
        System.out.println(twoCityScheduling.twoCitySchedCost(arr));
    }

}
