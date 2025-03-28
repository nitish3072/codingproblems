package scaler.two_pointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PairswithGivenDifference {

    public int solve(List<Integer> A, int B) {
        Collections.sort(A);
        int i=0, j=1, ans = 0;
        while (j<A.size()) {
            if (i==j) j++;
            else if(A.get(j) - A.get(i) > B) i++;
            else if (A.get(j) - A.get(i) < B) j++;
            else {
                ans++;
                if (Objects.equals(A.get(i), A.get(j))) {
                    while (i < A.size() && Objects.equals(A.get(i), A.get(j))) {
                        i++;
                    }
                    j = i+1;
                } else {
                    int iValue = A.get(i), jValue = A.get(j);
                    while (i < A.size() && Objects.equals(A.get(i), iValue)) {
                        i++;
                    }
                    while (j < A.size() && Objects.equals(A.get(j), jValue)) {
                        j++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2};
        PairswithGivenDifference sortedInsertPosition = new PairswithGivenDifference();
        System.out.println(sortedInsertPosition.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 0));
    }


}
