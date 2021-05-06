package leetcode.medium;

/**
 * https://leetcode.com/problems/spiral-matrix-ii/submissions/
 * check what movements(up, down, right, left) are presently. Switch movements on cases bwloe:
 * 1) no elements present in array on up, down, right or left respectively
 * 2) Element present on up, down, right or left respectively is not already filled with some value(i.e. it's zero by default in an array)
 */

public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int iIndex = 0;
        int jIndex = 0;
        int currentValue = 1;
        boolean rightMovement = true;
        boolean leftMovement = false;
        boolean upMovement = false;
        boolean downMovement = false;
        while(currentValue <= n*n) {
            arr[iIndex][jIndex] = currentValue++;
            if(rightMovement && jIndex+1 < n && arr[iIndex][jIndex+1]==0) {
                jIndex++;
            } else if(rightMovement) {
                iIndex++;
                rightMovement = false;
                downMovement = true;
            } else if(downMovement && iIndex+1 < n && arr[iIndex+1][jIndex]==0) {
                iIndex++;
            } else if(downMovement) {
                jIndex--;
                downMovement = false;
                leftMovement = true;
            } else if(leftMovement && jIndex-1 >=0 && arr[iIndex][jIndex-1]==0) {
                jIndex--;
            } else if(leftMovement) {
                iIndex--;
                leftMovement = false;
                upMovement = true;
            } else if(upMovement && iIndex-1 >=0 && arr[iIndex-1][jIndex]==0) {
                iIndex--;
            } else if(upMovement) {
                jIndex++;
                upMovement = false;
                rightMovement = true;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SpiralMatrixII spiralMatrixII = new SpiralMatrixII();
        int[][] arr = spiralMatrixII.generateMatrix(9);
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j] + "   ,  ");
            }
            System.out.println();
        }
    }

}
