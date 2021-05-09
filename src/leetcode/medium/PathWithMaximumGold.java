package leetcode.medium;

/**
 * https://leetcode.com/problems/path-with-maximum-gold/
 */
public class PathWithMaximumGold {

    public int getMaximumGold(int[][] grid) {
        int sum =0;
        for(int i=0; i<grid.length;i++) {
            for(int j=0; j<grid[i].length; j++) {
                sum = Math.max(sum, tranverseForGold(grid, i, j, 0));
            }
        }
        return sum;
    }

    public int tranverseForGold(int[][] grid, int i, int j, int sum) {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0) {
            return sum;
        }
        int temp = grid[i][j];
        sum = sum + grid[i][j];
        grid[i][j] = 0;
        int sum1 = tranverseForGold(grid, i, j-1, sum); // Left
        int sum2 = tranverseForGold(grid, i, j+1, sum); // Right
        int sum3 = tranverseForGold(grid, i-1, j, sum); // Up
        int sum4 = tranverseForGold(grid, i+1, j, sum); // Down
        grid[i][j] = temp;
        return Math.max(sum1, Math.max(sum2, Math.max(sum3, sum4)));
    }

    public static void main(String[] args) {
        PathWithMaximumGold pathWithMaximumGold = new PathWithMaximumGold();
        int[][] arr = {{0,6,0},{5,8,7},{0,9,0}};
        System.out.println(pathWithMaximumGold.getMaximumGold(arr));
    }

}
