package leetcode.medium;

/**
 * https://leetcode.com/problems/max-area-of-island/
 */
public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxSum = 0;
        for(int i=0 ;i <grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    int currentSum = findSumOfLinkedIslandDots(grid, i, j, 0);
                    maxSum = Math.max(maxSum, currentSum);
                }
            }
        }
        return maxSum;
    }

    public int findSumOfLinkedIslandDots(int[][] grid, int i, int j, int sum) {
        if (i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] == 0) {
            return sum;
        }
        sum += grid[i][j];
        grid[i][j] = 0;
        sum = findSumOfLinkedIslandDots(grid, i, j - 1, sum); // left
        sum = findSumOfLinkedIslandDots(grid, i, j + 1, sum); // right
        sum = findSumOfLinkedIslandDots(grid, i - 1, j, sum); // up
        sum = findSumOfLinkedIslandDots(grid, i + 1, j, sum); // down
        return sum;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();
        int[][] arr = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(arr));
    }
}
