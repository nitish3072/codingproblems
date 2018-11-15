import java.util.Scanner;

public class Knapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sum = scanner.nextLine();
        String n = scanner.nextLine();
        int[] values = new int[Integer.valueOf(n)];
        int[] wts = new int[Integer.valueOf(n)];
        for(int i=0;i<Integer.valueOf(n);i++) {
            String[] arr = scanner.nextLine().split(",");
            values[i] = Integer.valueOf(arr[0]);
            wts[i] = Integer.valueOf(arr[1]);
        }

        int[][] computed = new int[Integer.valueOf(n)][Integer.valueOf(sum)+1];
        for(int i=0;i<Integer.valueOf(n);i++) {
            for(int j=0;j<Integer.valueOf(sum)+1;j++) {
                if(j==0) {
                    computed[i][j] = 0;
                    continue;
                }
                if(i==0) {
                    computed[i][j] = j/wts[i]>0?values[i]:0;
                    continue;
                }
                if(j-wts[i]<0) {
                    computed[i][j] = computed[i-1][j];
                } else {
                    computed[i][j] = Math.max(computed[i-1][j],values[i] + computed[i][j-wts[i]]) ;
                }
            }
        }
        System.out.println(computed[Integer.valueOf(n)-1][Integer.valueOf(sum)]);
    }
}
/*
7
4
4,2
7,5
3,4
2,3
 */