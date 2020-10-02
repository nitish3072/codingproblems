package leetcode.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/submissions/
 */
public class MaximizeSumOfArrayAfterKNegations {

    /**
     * negativeNumbers > K : Find K MinimumNegative numbers, invert them and then Add them
     * negativeNumbers = K : Invert all negative numbers and Add them
     * negativeNumbers < K : Invert all negative numbers and find the smallest number and negate it for K - negativeNumbers times
     */
    public int largestSumAfterKNegations(int[] A, int K) {
        int negativeNumbersCount = findTotalNegativeNumbers(A);
        if(findTotalNegativeNumbers(A) > K) {
            int[] kSmallestNumbers = findKSmallestNumbers(A, K);
            int sumOfNegativeNumbersTwicePositive = sumOfNumbers(kSmallestNumbers) * -2;
            int sumOfAllNumbers = sumOfNumbers(A);
            return sumOfAllNumbers + sumOfNegativeNumbersTwicePositive;
        } else if(negativeNumbersCount == K) {
            int[] nSmallestNumbers = findKSmallestNumbers(A, K);
            return sumOfNumbers(nSmallestNumbers) * -2 + sumOfNumbers(A);
        } else {
            int[] allNegativeNumbers = findKSmallestNumbers(A, negativeNumbersCount);
            int sumOfAllNegativeNumbersTwicePositive = sumOfNumbers(allNegativeNumbers) * -2;
            int numberNearestToZero = findNumberNearestToZero(A);
            int sum = sumOfNumbers(A) + sumOfAllNegativeNumbersTwicePositive ;
            if((K-negativeNumbersCount)%2!=0) {
                sum += Math.abs(numberNearestToZero) * -2;
            }
            return sum;
        }
    }

    public int findTotalNegativeNumbers(int[] A) {
        int count = 0;
        for(Integer number: A) {
            if(number<0) {
                count++;
            }
        }
        return count;
    }

    public int sumOfNumbers(int[] A) {
        int sum = 0;
        for(Integer number: A) {
            sum += number;
        }
        return sum;
    }

    public int[] findKSmallestNumbers(int[] A, int K) {
        int[] sortedArray = Arrays.stream(A).sorted().toArray();
        int[] nSmallestArray = new int[K];
        for(int i = K-1;i>=0;i--) {
            nSmallestArray[i] = sortedArray[i];
        }
        return nSmallestArray;
    }

    public int findNumberNearestToZero(int[] A) {
        int smallest = 200;
        for(int number: A) {
            if(Math.abs(number) < Math.abs(smallest)) {
                smallest = number;
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        MaximizeSumOfArrayAfterKNegations maximizeSumOfArrayAfterKNegations = new MaximizeSumOfArrayAfterKNegations();
        int[] arr = {-2,4,4,4,6,3};
        int K = 1;
        System.out.println(maximizeSumOfArrayAfterKNegations.largestSumAfterKNegations(
                arr,
                K
        ));
    }
}
