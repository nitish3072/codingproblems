package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingDouble(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int startOfArray = intervals[0][0], endOfArray = intervals[0][1];
        for(int i =0;i<intervals.length; i++) {
            if(i==intervals.length-1) {
                endOfArray = Math.max(endOfArray, intervals[i][1]);
                result.add(new int[]{startOfArray, endOfArray});
            } else {
                if (endOfArray >= intervals[i + 1][0]) {
                    endOfArray = Math.max(endOfArray, intervals[i+1][1]);
                } else {
                    result.add(new int[]{startOfArray, endOfArray});
                    startOfArray = intervals[i + 1][0];
                    endOfArray = intervals[i + 1][1];
                }
            }
        }
        return result.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] arr = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        System.out.println(Arrays.deepToString(mergeIntervals.merge(arr)));
    }

}
