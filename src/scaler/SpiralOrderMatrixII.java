package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SpiralOrderMatrixII {

    public ArrayList<ArrayList<Integer>> generateMatrix(int A) {
        int[][] matrix = new int[A][A];
        if (A == 0) {
            return new ArrayList<>();
        }

        int rowStart = 0;
        int rowEnd = A-1;
        int colStart = 0;
        int colEnd = A-1;
        int num = 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i ++) {
                matrix[rowStart][i] = num ++;
            }
            rowStart ++;

            for (int i = rowStart; i <= rowEnd; i ++) {
                matrix[i][colEnd] = num ++;
            }
            colEnd --;

            for (int i = colEnd; i >= colStart; i --) {
                if (rowStart <= rowEnd)
                    matrix[rowEnd][i] = num ++;
            }
            rowEnd --;

            for (int i = rowEnd; i >= rowStart; i --) {
                if (colStart <= colEnd)
                    matrix[i][colStart] = num ++;
            }
            colStart ++;
        }
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int[] array : matrix) {
            list.add(new ArrayList<>(Arrays.stream(array)
                    .boxed()
                    .collect(Collectors.toList())));
        }
        return list;
    }

}
