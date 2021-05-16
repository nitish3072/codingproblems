package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0] * o[0] + o[1] * o[1]));
        return Arrays.copyOfRange(points, 0, k);
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] arr = {{3,3},{5,-1},{-2,4}};
        kClosestPointsToOrigin.kClosest(arr, 2);
    }
}
