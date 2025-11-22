package scaler.graph2;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class KnightOnChessBoard {

    public int knight(int A, int B, int C, int D, int E, int F) {
        if (C == E && D == F) return 0;
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[A][B];
        q.add(new Pair(C, D, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int[] row = new int[]{2, 2, 1, 1, -2, -2, -1, -1};
            int[] col = new int[]{1, -1, 2, -2, 1, -1, 2, -2};
            for (int k = 0; k < 8; k++) {
                int x = p.x + row[k];
                int y = p.y + col[k];
                if (x - 1 >= 0 && x - 1 < A && y - 1 >= 0 && y - 1 < B) {
                    if (x == E && y == F) {
                        return p.moves + 1;
                    }
                    if (visited[x - 1][y - 1] == 0) {
                        q.add(new Pair(x, y, p.moves + 1));
                    }
                    visited[x - 1][y - 1] = 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        KnightOnChessBoard b = new KnightOnChessBoard();
        System.out.println(b.knight(8,8,1,1,8,8));
    }

    private class Pair {
        public Pair(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            this.moves = moves;
        }
        public int x, y, moves;
    }

}
