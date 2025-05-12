package scaler;

import java.util.ArrayList;
import java.util.List;

public class Searchrowwisecolumnwisesorted {

    public int solve(ArrayList<ArrayList<Integer>> A, int B) {
        return 0;
    }

    public static void main(String[] args) {
        int[][] list = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < list[i].length; j++) {
                row.add(list[i][j]);
            }
            matrix.add(row);
        }

        Searchrowwisecolumnwisesorted sol = new Searchrowwisecolumnwisesorted();
        sol.solve(matrix, 2);
    }

}
