import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ar1 = scanner.nextLine().split(",");
        int[] ar = new int[ar1.length];
        int[] computed = new int[ar1.length];
        for(int i=0;i<ar1.length; i++) {
            computed[i] = 1;
            ar[i] = Integer.valueOf(ar1[i]);
        }
        // max[i] = 1 + Max(LIS(j)) 0<j<i and array[i]>array[j]
        // Else max[i] = 1
        for(int i=0;i<ar1.length;i++) {
            int max = 0;
            int value = 0;
            for(int j=0; j<i;j++) {
                if(computed[j]>max) {
                    max = computed[j];
                    value = ar[j];
                }
            }
            if(value<ar[i]) {
                computed[i] = 1 + max;
            }
        }
        System.out.println(computed);
    }
}
