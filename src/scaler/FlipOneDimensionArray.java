package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FlipOneDimensionArray {

    public ArrayList<Integer> flip(String A) {
        int indexOfmaxSum = -1;
        int sum = 0;
        int maxSum = 0;
        int[] sumArray = new int[A.length()];
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) == '0') {
                sum = sum + A.charAt(i) - '0' + 1;
            } else {
                sum = sum + A.charAt(i) - '0' - 2;
            }
            sumArray[i] = sum;
            if(sum > maxSum) {
                indexOfmaxSum = i;
            }
            maxSum = Math.max(maxSum, sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        if(indexOfmaxSum >= 0) {
            int i = indexOfmaxSum;
            while (sumArray[i] > 1) {
                i--;
            }
            result.add(i+1);
            result.add(indexOfmaxSum+1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "1101010001";
        FlipOneDimensionArray flipOneDimensionArray = new FlipOneDimensionArray();
        System.out.println(flipOneDimensionArray.flip(s));
    }

}
