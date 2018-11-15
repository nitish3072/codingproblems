import java.util.Scanner;

public class LongestPalindromicSubsequence {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(",");
        int[][] computed = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    computed[i][j] = 1;
                }
            }
        }
        int orgI = 0, orgJ = 1;
        while (orgJ<arr.length) {
            int j = orgJ;
            int i = orgI;
            while (j < arr.length) {
                if (arr[i].equalsIgnoreCase(arr[j])) {
                    computed[i][j] = computed[i + 1][j - 1] + 2;
                } else {
                    computed[i][j] = Math.max(computed[i + 1][j], computed[i][j -1]);
                }
                i++;j++;
            }
            orgJ ++;
        }
        System.out.println(computed);
        for (int i = 0; i < computed.length; i++) {
            for (int j = 0; j < computed[i].length; j++) {
                System.out.printf(String.valueOf(computed[i][j]));
            }
            System.out.println();
        }

    }

}
