import java.util.Scanner;

public class CoinChangeWays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = Integer.valueOf(scanner.nextLine());
        String[] arr = scanner.nextLine().split(",");

        int[][] computed = new int[arr.length][sum+1];


        for(int i=0; i<arr.length;i++) {
            for(int j=0;j<sum+1;j++) {
                if(j==0) {
                    computed[i][j] = 1;
                    continue;
                }
                if(i==0) {
                    computed[i][j] = j%(Integer.valueOf(arr[i])) == 0?1:0;
                    continue;
                }
                if((j-Integer.valueOf(arr[i]))>=0) {
                    computed[i][j] = computed[i-1][j] + computed[i][j-Integer.valueOf(arr[i])];
                } else {
                    computed[i][j] = computed[i-1][j];
                }
            }
        }
        System.out.println(computed[arr.length-1][sum]);
    }
}
/*
10
2,5,3,6
 */
