package scaler;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CheckPairSum {

    public int solve(int A, List<Integer> B) {
        Set<Integer> set = new HashSet<>();
        set.add(B.get(0));
        for (int i = 0; i < B.size(); i++) {
            Integer elem = B.get(i);
            Integer target = A - elem;
            if(set.contains(target)) {
                return 1;
            }
            set.add(elem);
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{9, 10, 7, 10, 9, 1, 5, 1, 5};
        CheckPairSum checkPairSum = new CheckPairSum();
        System.out.println(checkPairSum.solve(21, Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }
}
