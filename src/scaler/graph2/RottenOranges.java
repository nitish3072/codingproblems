package scaler.graph2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        int fresh = 0;
        Queue<Triplet> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.get(i).get(j) == 2) {
                    q.add(new Triplet(i, j, 0));
                } else if (A.get(i).get(j) == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }
        int[] row = new int[]{0, 1, 0, -1};
        int[] col = new int[]{1, 0, -1, 0};
        while (!q.isEmpty()) {
            Triplet t = q.poll();
            int time = t.minutes;
            for (int k = 0; k <= 3; k++) {
                int x = t.i + row[k];
                int y = t.j + col[k];
                if (x >= 0 && x < n && y >= 0 && y < m && A.get(x).get(y) == 1) {
                    A.get(x).set(y, 2);
                    fresh--;
                    q.add(new Triplet(x, y, time + 1));
                }
                if (fresh == 0) {
                    return time + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        A.add(new ArrayList<>(List.of(2,2,0,2,0,1,1,1,0,0,0,0,1,0,0,2,1,1,2,1,2,2,1,0,1,0,2,2,0,2,0,2,0,1,0,2,1,2,1,0,1,2,2,0)));
        A.add(new ArrayList<>(List.of(1,2,2,0,2,1,1,1,0,1,2,1,1,2,1,0,0,2,2,2,0,2,2,2,2,1,0,1,0,0,0,2,0,1,2,2,2,0,0,1,2,1,2,2)));
        A.add(new ArrayList<>(List.of(2,1,1,0,1,1,1,2,0,2,2,2,0,0,1,0,2,2,1,1,2,2,2,1,0,0,2,1,0,1,1,0,0,0,1,2,2,2,2,0,0,2,1,0)));
        A.add(new ArrayList<>(List.of(2,0,2,2,0,2,0,1,1,2,2,0,2,0,0,0,1,0,1,0,0,1,1,1,1,2,1,2,1,1,0,0,2,0,1,2,0,2,1,1,0,2,1,1)));
        A.add(new ArrayList<>(List.of(1,2,0,0,2,2,1,0,2,2,0,1,1,0,1,1,2,1,1,0,2,2,2,2,1,1,2,1,1,1,1,0,0,1,2,0,0,2,1,1,1,1,0,2)));
        A.add(new ArrayList<>(List.of(0,1,1,0,0,2,0,0,2,0,2,2,1,2,1,0,1,1,2,2,1,2,1,2,2,2,1,0,2,2,0,2,0,2,0,2,2,2,1,2,1,2,2,1)));
        A.add(new ArrayList<>(List.of(2,1,2,1,2,1,0,2,0,1,0,1,0,1,2,0,0,1,0,0,1,0,0,2,1,0,1,2,0,0,2,2,1,0,1,1,1,0,1,2,1,2,1,1)));
        A.add(new ArrayList<>(List.of(1,1,2,2,1,2,2,2,0,2,2,0,2,2,2,0,1,1,1,1,0,2,0,0,0,1,1,0,2,2,2,2,2,0,2,0,2,1,1,1,0,0,2,2)));
        A.add(new ArrayList<>(List.of(2,0,2,0,2,2,0,0,1,1,2,0,2,0,2,2,1,0,1,0,1,1,1,1,2,0,2,2,0,0,0,0,0,0,1,0,1,1,2,1,2,0,2,1)));
        A.add(new ArrayList<>(List.of(2,0,2,0,1,0,0,1,0,1,0,0,0,0,1,2,2,1,2,1,2,1,2,1,1,0,1,1,2,1,0,0,1,0,2,0,2,1,2,1,1,0,0,0)));
        A.add(new ArrayList<>(List.of(0,1,0,0,2,2,1,2,0,1,0,2,0,0,2,1,0,0,0,2,0,2,2,1,1,1,2,1,1,1,1,2,2,0,1,0,1,0,1,1,2,0,0,1)));
        A.add(new ArrayList<>(List.of(1,1,2,0,2,0,1,0,0,0,2,2,2,2,2,0,1,1,1,0,1,0,0,1,0,0,0,0,1,2,0,0,2,2,0,2,0,1,1,2,0,0,0,1)));
        A.add(new ArrayList<>(List.of(2,0,1,2,1,1,2,2,1,0,0,2,1,2,1,0,2,2,2,1,2,2,1,1,0,0,0,0,2,2,0,1,2,2,2,2,1,1,0,2,0,0,1,2)));
        A.add(new ArrayList<>(List.of(1,0,2,0,2,2,0,1,0,1,0,1,0,1,0,1,2,2,2,2,2,1,0,2,2,2,2,1,1,2,1,1,1,0,1,1,2,0,1,1,2,0,1,2)));
        A.add(new ArrayList<>(List.of(2,2,2,2,0,0,2,0,0,1,1,1,1,2,2,2,2,0,2,2,0,2,2,2,2,1,2,1,0,1,1,2,0,0,1,2,1,1,0,2,0,1,2,1)));
        A.add(new ArrayList<>(List.of(2,0,2,0,1,0,0,2,2,1,0,2,2,2,1,1,1,2,0,0,0,2,0,1,0,1,0,2,1,1,1,0,2,2,2,0,2,1,1,0,2,1,1,1)));
        A.add(new ArrayList<>(List.of(1,0,2,1,1,1,1,2,0,1,2,2,1,1,0,1,0,2,0,1,1,2,0,2,1,2,2,2,1,0,1,1,1,1,0,2,0,2,2,1,2,1,1,0)));
        A.add(new ArrayList<>(List.of(2,0,0,2,1,0,2,1,0,2,0,1,1,2,2,2,2,1,2,0,0,2,0,2,2,1,0,2,1,0,0,0,0,1,0,0,1,1,0,0,1,2,0,0)));
        A.add(new ArrayList<>(List.of(2,2,2,2,1,0,2,2,0,0,2,0,0,1,2,0,2,1,2,1,2,2,2,2,1,0,1,1,0,1,2,0,0,1,1,0,0,1,2,0,2,2,2,2)));
        A.add(new ArrayList<>(List.of(0,0,0,0,2,0,0,2,2,2,1,2,0,2,0,0,1,1,2,0,2,2,0,2,2,0,0,1,1,2,2,2,0,2,1,0,2,0,2,1,1,1,1,0)));
        A.add(new ArrayList<>(List.of(0,2,0,2,2,2,1,0,2,0,1,2,0,2,1,1,2,1,2,0,2,0,0,2,2,1,0,1,0,0,2,0,1,0,1,1,1,0,0,1,0,0,1,1)));
        A.add(new ArrayList<>(List.of(2,1,1,1,1,0,0,2,2,1,2,2,0,2,2,2,1,1,2,0,1,2,1,2,2,2,1,0,2,1,1,0,2,2,1,0,2,0,0,0,0,2,1,1)));
        System.out.println(rottenOranges.solve(A));
    }

    public class Triplet {
        public Triplet(int i, int j, int minutes) {
            this.i = i;
            this.j = j;
            this.minutes = minutes;
        }
        public int i, j, minutes;
    }

}
