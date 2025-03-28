package scaler.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Subarraywithgivensum {

    public ArrayList<Integer> solve(List<Integer> A, int B) {
        int n = A.size();
        long[] prefixSum = new long[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i] = (i - 1 < 0) ? A.get(0) : prefixSum[i - 1] + A.get(i);
        }
        int i = 0, j = 0;
        long sum = 0;
        while (i < A.size() && j < A.size()) {
            if(i==0) {
                sum = prefixSum[j];
            } else {
                sum = prefixSum[j] - prefixSum[i - 1];
            }
            if (sum > B) {
                i++;
            } else if (sum < B) {
                j++;
            } else {
                return new ArrayList<>(A.subList(i, j + 1));
            }
        }
        return new ArrayList<>(Collections.singletonList(-1));
    }

    public static void main(String[] args) {
        int[] ints = new int[]{15,2,5,6,9};
        Subarraywithgivensum sortedInsertPosition = new Subarraywithgivensum();
        System.out.println(sortedInsertPosition.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 7));
    }

}
