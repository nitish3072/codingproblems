import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://practice.geeksforgeeks.org/problems/trapping-rain-water/0
 */
public class TrappingRainWater {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.valueOf(reader.readLine());
        while (testCases-- > 0) {
            int size = Integer.valueOf(reader.readLine());
            String[] strs = reader.readLine().trim().split(" ");
            int[] arr = new int[size];
            for(int i =0;i<size;i++) {
                arr[i] = Integer.valueOf(strs[i]);
            }

            // Max on left side of a any element
            int[] maxOnLeftSide = new int[arr.length];
            maxOnLeftSide[0]=arr[0];
            for(int i = 1;i<arr.length;i++) {
                if(arr[i]>maxOnLeftSide[i-1]) {
                    maxOnLeftSide[i] = arr[i];
                } else {
                    maxOnLeftSide[i] = maxOnLeftSide[i-1];
                }
            }

            // Max of right side of an element
            int[] maxOnRightSide = new int[arr.length];
            maxOnRightSide[arr.length-1]=arr[arr.length-1];
            for(int i =arr.length-2;i>=0;i--) {
                if(arr[i]>maxOnRightSide[i+1]) {
                    maxOnRightSide[i] = arr[i];
                } else {
                    maxOnRightSide[i] = maxOnRightSide[i+1];
                }
            }

            int sum = 0;
            for(int i = 0;i<arr.length;i++) {
                if(arr[i]>maxOnLeftSide[i] || arr[i]>maxOnRightSide[i]) {
                    sum = sum;
                } else {
                    sum+=Math.min(maxOnLeftSide[i], maxOnRightSide[i]) - arr[i];
                }
            }
            System.out.println(sum);

        }
    }
}
