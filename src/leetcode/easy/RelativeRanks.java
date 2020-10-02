package leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/relative-ranks/
 */
public class RelativeRanks {

    public String[] findRelativeRanks(int[] nums) {
        int[] sortedArray = Arrays.stream(nums).sorted().toArray();
        String[] stringArray = new String[sortedArray.length];
        for (int i =0 ;i<sortedArray.length; i++) {
            stringArray[i] = String.valueOf(sortedArray[i]);
        }
        if(stringArray.length>0) {
            stringArray[0] = "Gold Medal";
        }
        if(stringArray.length>1) {
            stringArray[1] = "Silver Medal";
        }
        if(stringArray.length>2) {
            stringArray[2] = "Bronze Medal";
        }
        return stringArray;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 4, 3, 2, 1 };
        RelativeRanks relativeRanks = new RelativeRanks();
        System.out.println(Arrays.toString(relativeRanks.findRelativeRanks(arr)));
    }
}
