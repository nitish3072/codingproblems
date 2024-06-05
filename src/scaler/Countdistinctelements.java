package scaler;

import java.util.*;
import java.util.stream.Collectors;

public class Countdistinctelements {

    public int solve(List<Integer> A) {
        HashSet<Integer> set = new HashSet<>(A);
        return set.size();
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3, 4, 3, 6, 6};
        Countdistinctelements countdistinctelements = new Countdistinctelements();
        System.out.println(countdistinctelements.solve(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }

}
