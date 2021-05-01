package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-closed-islands/
 */
public class NumberClosedIslands {


    public int closedIsland(int[][] grid) {
        if (grid.length == 1) {
            return 0;
        } else if (grid[0].length == 1) {
            return 0;
        }
        int landBodies = 1;
        Map<Integer, Integer> nonLandBodies = new HashMap<>();
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 0) {
                    flowLand(grid, i, j, ++landBodies);
                }
                if (grid[i][j] > 1) {
                    if (i - 1 == 0 && grid[i - 1][j] == 0) {
                        nonLandBodies.put(grid[i][j], grid[i][j]);
                    }
                    if (i + 1 == grid.length - 1 && grid[i + 1][j] == 0) {
                        nonLandBodies.put(grid[i][j], grid[i][j]);
                    }
                    if (j - 1 == 0 && grid[i][j - 1] == 0) {
                        nonLandBodies.put(grid[i][j], grid[i][j]);
                    }
                    if (j + 1 == grid[i].length - 1 && grid[i][j + 1] == 0) {
                        nonLandBodies.put(grid[i][j], grid[i][j]);
                    }
                }
            }
        }
        return landBodies - nonLandBodies.keySet().size() - 1;
    }

    private void flowLand(int[][] grid, int i, int j, int landBodies) {
        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) {
            return;
        }
        grid[i][j] = landBodies;
        if (grid[i - 1][j] == 0) {
            flowLand(grid, i - 1, j, landBodies);
        }
        if (grid[i][j + 1] == 0) {
            flowLand(grid, i, j + 1, landBodies);
        }
        if (grid[i][j - 1] == 0) {
            flowLand(grid, i, j - 1, landBodies);
        }
        if (grid[i + 1][j] == 0) {
            flowLand(grid, i + 1, j, landBodies);
        }
    }

    public static void main(String[] args) {
        NumberClosedIslands numberClosedIslands = new NumberClosedIslands();
        int[][] arr = {{0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1}, {0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1}, {1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0}, {1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1}, {1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0}, {1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1}, {1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0}, {1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1}, {0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0, 1}};
        System.out.println(numberClosedIslands.closedIsland(arr));
    }

}
