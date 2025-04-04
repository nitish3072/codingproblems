package scaler.two_pointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PairswithgivensumII {

    public int solve(List<Integer> A, int B) {
        int modulo = 1000000007;
        Collections.sort(A);
        int i = 0, j = A.size() - 1;
        long ans = 0;
        while (i < j) {
            if (A.get(j) + A.get(i) > B) j--;
            else if (A.get(j) + A.get(i) < B) i++;
            else {
                if (Objects.equals(A.get(i), A.get(j))) {
                    ans += (long) (j - i + 1) * (j - i) / 2;
                    return (int) (ans % modulo);
                } else {
                    int iSum = 1, jSum = 1, iValue = A.get(i), jValue = A.get(j);
                    i++;j--;
                    while (Objects.equals(A.get(i), iValue)) {
                        iSum++;
                        i++;
                    }
                    while (Objects.equals(A.get(j), jValue)) {
                        jSum++;
                        j--;
                    }
                    ans = ((ans % modulo) + ((long) (iSum % modulo) * (jSum % modulo)) % modulo) % modulo;
                }
            }
        }
        return (int) (ans % modulo);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 1, 1};
        PairswithgivensumII sortedInsertPosition = new PairswithgivensumII();
        System.out.println(sortedInsertPosition.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 2));
    }

}
