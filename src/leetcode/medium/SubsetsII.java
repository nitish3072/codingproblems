package leetcode.medium;

/**
 * https://leetcode.com/problems/subsets-ii/
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return subset(new ArrayList<>(), new ArrayList<>(), nums, 0);
    }

    public List<List<Integer>> subset(List<List<Integer>> list, List<Integer> currentList, int[] nums, int index) {
        if(!list.contains(currentList)) list.add(new ArrayList<>(currentList));
        if(index>nums.length-1) return list;
        for(int i=index; i<nums.length; i++) {
            currentList.add(nums[i]);
            subset(list, currentList, nums, i+1);
            currentList.remove((Object) nums[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        int[] arr = {4,4,4,1,4};
        System.out.println(subsetsII.subsetsWithDup(arr));
    }

}
