package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combinations/
 */

public class PossibleCombinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backTrack(list, new ArrayList<>(), 1, n, k);
        return list;
    }

    public void backTrack(List<List<Integer>> list, List<Integer> currentList,  int index, int n, int k) {
        if (currentList.size() == k) {
            list.add(new ArrayList<>(currentList));
        } else {
            for (int i = index; i <= n; i++) {
                currentList.add(i);
                backTrack(list, currentList, i + 1, n, k);
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        PossibleCombinations possibleCombinations = new PossibleCombinations();
        List<List<Integer>> list = possibleCombinations.combine(4, 2);
        System.out.println(list);
    }

}
