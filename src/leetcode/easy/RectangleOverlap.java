package leetcode.easy;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[][] rec1Points = {{rec1[0], rec1[1]},{rec1[0], rec1[3]},{rec1[2], rec1[3]},{rec1[2], rec1[1]}};
        int[][] rec2Points = {{rec2[0], rec2[1]},{rec2[0], rec2[3]},{rec2[2], rec2[3]},{rec2[2], rec2[1]}};
        if(pointsLieInRectangle(rec2Points, rec1) || pointsLieInRectangle(rec1Points, rec2)) {
            return true;
        }
        return false;
    }

    public boolean pointsLieInRectangle(int[][] points, int[] rec1) {
        for(int i=0;i<points.length;i++) {
            int[] point = points[i];
            if((rec1[0] < point[0] && rec1[2] > point[0]) && (rec1[1] < point[1] && rec1[3] > point[1])) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        RectangleOverlap addStrings = new RectangleOverlap();
        int[] rec1 = {7,8,13,15}, rec2 = {10,8,12,20};
        System.out.println(addStrings.isRectangleOverlap(rec1, rec2));
    }
}
