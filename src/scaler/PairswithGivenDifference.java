package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PairswithGivenDifference {

    public int solve(List<Integer> A, int B) {
        Collections.sort(A);
        int i = 0, j = 1, ans = 0;
        while (j < A.size()) {
            if(i==j) { j++; continue; }
            if (A.get(j) - A.get(i) > B) i++;
            else if (A.get(j) - A.get(i) < B) j++;
            else {
                while (i + 1 < A.size() && A.get(i).equals(A.get(i + 1))) {
                    i++;
                }
                while (j + 1 < A.size() && A.get(j).equals(A.get(j + 1))) {
                    j++;
                }
                ans++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2};
        PairswithGivenDifference sw = new PairswithGivenDifference();
        System.out.println(sw.solve(Arrays.stream(ints).boxed().collect(Collectors.toList()), 0));
    }

}
