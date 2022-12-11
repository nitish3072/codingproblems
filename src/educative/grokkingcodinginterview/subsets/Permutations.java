package educative.grokkingcodinginterview.subsets;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, new ArrayList<>(), nums);
        return result;
    }

    public static void permute(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if(tempList.size()==nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for(int i = 0; i<nums.length; i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                permute(result, tempList, nums);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String args[]) {
        int[][] inputWord = {{1,2,3}, {0,1}, {1,2,4,3}};
        for (int index = 0; index < inputWord.length; index++) {
            List<List<Integer>> permutedWords = permute(inputWord[index]);
            System.out.println(index + 1 + ".\t Input string: '" + inputWord[index] + "'");
            System.out.println("\t All possible permutations are: " + permutedWords);
        }
    }

}
