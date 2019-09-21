import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ChocolateDistributionProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            int size = Integer.valueOf(reader.readLine());
            String[] strs = reader.readLine().trim().split(" ");
            int numberOfStudents = Integer.valueOf(reader.readLine());
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }

            Arrays.sort(arr);
            int i=arr.length-1;
            int j=arr.length-numberOfStudents;
            int resultDiff = Integer.MAX_VALUE;
            while (j>=0){
                int diff = arr[i]-arr[j];
                if(diff < resultDiff) {
                    resultDiff = diff;
                }
                j--;i--;
            }
            System.out.println(resultDiff);
        }
    }
}
