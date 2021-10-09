package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return getAllSumForValue(candidates, target, new ArrayList<>(), new ArrayList<>(), 0, 0);
    }

    public List<List<Integer>> getAllSumForValue(int[] candidates,
                                                 int target,
                                                 List<List<Integer>> finalList,
                                                 List<Integer> list,
                                                 int index,
                                                 int currentSum) {
        if (currentSum == target) {
            finalList.add(new ArrayList<>(list));
            return finalList;
        }
        if (currentSum > target) {
            return finalList;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            currentSum = currentSum + candidates[i];
            list.add(candidates[i]);
            getAllSumForValue(candidates, target, finalList, list, i + 1, currentSum);
            list.remove(list.size()-1);
            currentSum = currentSum - candidates[i];
        }
        return finalList;
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        CombinationSum2 combinationSum2 = new CombinationSum2();
        List<List<Integer>> list= combinationSum2.combinationSum2(arr, 8);
        System.out.println("Here !");
    }
}
