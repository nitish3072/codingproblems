package scaler.two_pointers;

import scaler.searching_3_binary.AllocateBooks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContainerWithMostWater {

    public int maxArea(List<Integer> A) {
        int i = 0, j = A.size()-1, ans = 0;
        while (i<j) {
            ans = Math.max(ans, Math.min(A.get(i), A.get(j)) * (j - i));
            if (A.get(i) > A.get(j)) j--;
            else i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 5, 4, 3};
        ContainerWithMostWater sortedInsertPosition = new ContainerWithMostWater();
        System.out.println(sortedInsertPosition.maxArea(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }

}
