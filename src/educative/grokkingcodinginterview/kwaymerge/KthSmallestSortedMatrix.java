package educative.grokkingcodinginterview.kwaymerge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestSortedMatrix {

    public static int kthSmallestElement(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < matrix.length; i++) pq.add(new int[]{matrix[i][0], i, 0});
        int result = 0;
        for (int i = 0; i < k; i++) {
            if (pq.isEmpty()) break;
            int[] element = pq.poll();
            result = element[0];
            if (element[2] + 1 < matrix[0].length)
                pq.add(new int[]{matrix[element[1]][element[2] + 1], element[1], element[2] + 1});
        }
        return result;
    }

    public static void main(String[] args) {
        int[][][] matrix = {{{2, 6, 8},
                {3, 7, 10},
                {5, 8, 11}},

                {{1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}},

                {{},
                        {}},

                {{1, 1, 3, 8},
                        {5, 5, 7, 9},
                        {3, 5, 8, 12}},

                {{2, 2, 6, 6, 8, 9},
                        {1, 4, 7, 10, 10, 22},
                        {5, 7, 9, 11, 13, 15},
                        {44, 55, 66, 77, 88, 99}}};

        int [] k = {3, 4, 1, 30, 8};
        for(int i=0; i<k.length; i++){
            System.out.print(i+1);
            System.out.println(".\tInput matrix: "+ Arrays.deepToString(matrix[i]));
            System.out.println("\tK =  "+k[i]);
            System.out.println("\tKth smallest number in the matrix is: "+kthSmallestElement(matrix[i], k[i]));
        }

    }
}
