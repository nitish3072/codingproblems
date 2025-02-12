package educative.grokkingcodinginterview.subsets;

import java.util.ArrayList;
import java.util.List;

public class PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            int[] present = new int[20];
            for (int num : nums) {
                present[num+10]++;
            }
            permute(result, new ArrayList<>(), nums, present);
            return result;
    }

    public static void permute(List<List<Integer>> result, List<Integer> tempList, int[] nums, int[] present) {
        if(tempList.size()==nums.length) {
            if(!result.contains(tempList)) result.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i<nums.length; i++) {
                if(present[nums[i]+10]==0) continue;
                tempList.add(nums[i]);
                present[nums[i]+10]--;
                permute(result, tempList, nums, present);
                present[tempList.get(tempList.size()-1)+10]++;
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String args[]) {
        int[][] inputWord = {{1,2,2}, {0,1, 1}, {-1,2,-1,2,1,-1,2,1}};
        for (int index = 0; index < inputWord.length; index++) {
            List<List<Integer>> permutedWords = permuteUnique(inputWord[index]);
            System.out.println(index + 1 + ".\t Input string: '" + inputWord[index] + "'");
            System.out.println("\t All possible permutations are: " + permutedWords);
        }
    }

}
