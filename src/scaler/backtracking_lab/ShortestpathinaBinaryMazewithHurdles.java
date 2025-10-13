package scaler.backtracking_lab;

import java.util.ArrayList;

public class ShortestpathinaBinaryMazewithHurdles {

    int min = Integer.MAX_VALUE;
    public int FindShortestPath(ArrayList<ArrayList<Integer>> A, int B, int C, int D, int E) {
        int[][] visited= new int[A.size()][A.get(0).size()];
        printAllPaths(A, visited, B, C, D, E, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public void printAllPaths( ArrayList<ArrayList<Integer>> list, int[][] visit, int i, int j, int p, int q, int count) {
        if (i == p && j == q) {
            min = Math.min(min, count);
            return;
        }

        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        for (int k = 0; k <= 3; k++) {
            int x = i + row[k];
            int y = j + col[k];
            if (x >= 0 && x < list.size() && y >= 0 && y < list.get(0).size() && list.get(x).get(y) == 1 && visit[x][y] == 0) {
                visit[x][y] = 1;
                printAllPaths(list, visit, x, y, p, q, count + 1);
                visit[x][y] = 0;
            }
        }
    }

    public static void main(String[] args) {
        ShortestpathinaBinaryMazewithHurdles shortestpathinaBinaryMazewithHurdles = new ShortestpathinaBinaryMazewithHurdles();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                row.add(0);
            }
            list.add(row);
        }
        shortestpathinaBinaryMazewithHurdles.FindShortestPath(list, 1, 1, 3, 2);
    }
}
