import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0
 */
public class StockBuyAndSell {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            int size = Integer.valueOf(reader.readLine());
            String[] strs = reader.readLine().trim().split(" ");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }

            int minIndex = 0;
            boolean isProfit = false;
            for(int i=0;i<arr.length-1;i++) {
                if(arr[i]>arr[i+1]) {
                    minIndex=i+1;
                } else {
                    break;
                }
            }
            int j = minIndex+1;
            while (j<arr.length) {
                if(arr[j]<arr[j-1]) {
                    if(minIndex!=j-1) {
                        isProfit = true;
                        System.out.print("(" + minIndex + " " + (j - 1) + ") ");
                    }
                    minIndex = j;
                }
                j++;
            }
            if(minIndex!=j-1) {
                isProfit = true;
                System.out.print("(" + minIndex + " " + (j-1) + ") ");
            }
            if(!isProfit) {
                System.out.print("No Profit");
            }
            System.out.println();
        }
    }
}
