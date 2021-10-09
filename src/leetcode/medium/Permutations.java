package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        back(list, new ArrayList<>(), nums);
        return list;
    }

    private void back(List<List<Integer>> list, List<Integer> currentList, int[] nums) {
        if(currentList.size()==nums.length) {
            list.add(new ArrayList<>(currentList));
        } else {
            for(int i=0; i<nums.length; i++) {
                if(currentList.contains(nums[i])) continue;
                currentList.add(nums[i]);
                back(list, currentList, nums);
                currentList.remove(currentList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,1,9,11};
        Permutations permutations = new Permutations();
        permutations.permute(arr);
    }

}
