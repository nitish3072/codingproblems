package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PairswithgivensumII {

    public long solve(List<Integer> A, int B) {
        int i = 0, j = A.size() - 1;
        long sum = 0;
        while (i < j) {
            if (A.get(i) + A.get(j) > B) j--;
            else if (A.get(i) + A.get(j) < B) i++;
            else {
                if (A.get(i).equals(A.get(j))) {
                    long c = j - i + 1;
                    sum += c * (c - 1) / 2;
                    return sum;
                } else {
                    long sumi = 1;
                    while (A.get(i).equals(A.get(i + 1))) {
                        sumi += 1;
                        i++;
                    }
                    long sumj = 1;
                    while (A.get(j).equals(A.get(j - 1))) {
                        sumj += 1;
                        j--;
                    }
                    sum += sumi * sumj;
                    i++;j--;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666,4629666};
        PairswithgivensumII sw = new PairswithgivensumII();
        System.out.println(sw.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 9259332));
    }

}
