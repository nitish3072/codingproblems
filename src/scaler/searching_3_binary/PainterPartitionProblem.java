package scaler.searching_3_binary;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PainterPartitionProblem {

    public int paint(int A, int B, List<Integer> C) {
        int modulus = 10000003;
        int s = Collections.max(C), e = C.stream().mapToInt(Integer::intValue).sum(), mid = 0, ans = 0;
        while (s <= e) {
            mid = s + ((e - s) / 2);
            if (isPossibleToPaint(C, A, mid)) {
                e = mid - 1;
                ans = mid;
            } else {
                s = mid + 1;
            }
        }
        return (new BigInteger(String.valueOf(ans)).multiply(BigInteger.valueOf(B))).mod(BigInteger.valueOf(modulus)).intValue();
    }

    private boolean isPossibleToPaint(List<Integer> C, int A, int mid) {
        int painters = 1;
        int sum = 0;
        for (Integer elem: C) {
            sum += elem;
            if(sum > mid) {
                painters++;
                sum = elem;
            }
        }
        return painters <= A;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1000000,1000000};
        PainterPartitionProblem sortedInsertPosition = new PainterPartitionProblem();
        System.out.println(sortedInsertPosition.paint(1, 1000000, Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }
}
