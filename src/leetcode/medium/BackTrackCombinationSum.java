package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class BackTrackCombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        int n = candidates.length;
//        int[][] dp = new int[n + 1][target + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= target; j++) {
//                if (j % candidates[i - 1] == 0) {
//                    dp[i][j] = dp[i - 1][j] + 1;
//                } else if (candidates[i - 1] > j) {
//                    dp[i][j] = dp[i - 1][j];
//                } else if (candidates[i - 1] == j) {
//                    dp[i][j] = dp[i - 1][j] + 1;
//                } else if (candidates[i - 1] < j) {
//                    dp[i][j] = dp[i - 1][j];
//                    for (int k = j - candidates[i - 1]; k >= 0; k = k - candidates[i - 1]) {
//                        dp[i][j] += dp[i - 1][k];
//                    }
//                }
//            }
//        }
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start) {
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        BackTrackCombinationSum combinationSum = new BackTrackCombinationSum();
        int[] arr = {2,3,6,7};
        System.out.println(combinationSum.combinationSum(arr, 7));
    }
}
