package educative.grokkingcodinginterview.twoheaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumCapital {
    public static int maximumCapital(int c, int k, int[] capitals, int[] profits) {

        PriorityQueue<int[]> capsQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> profsQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < capitals.length; i++) {
            int capital = capitals[i];
            int profit = profits[i];
            capsQueue.add(new int[] {capital, profit});
        }

        int currentCapital = c;
        for (int i = 1; i <= k; i++) {
            while (!capsQueue.isEmpty() && currentCapital>=capsQueue.peek()[0]) {
                profsQueue.add(capsQueue.poll());
            }

            if(profsQueue.isEmpty()) break;

            currentCapital = currentCapital + profsQueue.poll()[1];
        }

        return currentCapital;
    }

    public static void main(String[] args) {
        int[] c = {11, 1, 2, 1, 7, 2};
        int[] k = {11, 2, 3, 3, 2, 4};
        int[][] capitals = {
                {11, 12, 13},
                {1, 2, 2, 3},
                {1, 3, 4, 5, 6},
                {1, 2, 3, 4},
                {6, 7, 8, 10},
                {2, 3, 5, 6, 8, 12}
        };
        int[][] profits = {
                {1, 2, 3},
                {2, 4, 6, 8},
                {1, 2, 3, 4, 5},
                {1, 3, 5, 7},
                {4, 8, 12, 14},
                {1, 2, 5, 6, 8, 9}
        };
        for (int i = 0; i < k.length; i++) {
            System.out.println((i + 1) + ".\tProject capital requirements: " + Arrays.toString(capitals[i]));
            System.out.println("\tProject expected profits: " + Arrays.toString(profits[i]));
            System.out.println("\tNumber of projects: " + k[i]);
            System.out.println("\tStart-up capital: " + c[i]);
            System.out.println("\n\t\tProcessing: ");
            System.out.println("\n\tMaximum Capital earned: " + maximumCapital(c[i], k[i], capitals[i], profits[i]));
        }
    }

}
