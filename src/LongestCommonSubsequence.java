import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ar1 = scanner.nextLine().split(",");
        String[] ar2 = scanner.nextLine().split(",");
        int[][] finalArr = new int[ar1.length+1][ar2.length+1];
        for(int i = 1;i<ar1.length+1;i++) {
            boolean altered = false;
            for(int j = 1;j<ar2.length+1;j++) {
                if(altered) {
                    finalArr[i][j] = finalArr[i][j-1];
                } else if(ar1[i-1].equalsIgnoreCase(ar2[j-1]) ) {
                    int max = Math.max(finalArr[i-1][j], finalArr[i][j-1]);
                    finalArr[i][j] = max + 1;
                    altered = true;
                } else {
                    int max = Math.max(finalArr[i-1][j], finalArr[i][j-1]);
                    finalArr[i][j] = max;
                }
            }
        }
        System.out.println(finalArr);
        for(int i = 0;i<finalArr[0].length;i++) {
            for (int j = 0; j < finalArr.length; j++) {
                System.out.printf(String.valueOf(finalArr[j][i]) + ",");
            }
            System.out.println();
        }
    }
}