package scaler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RainWaterTrapped {

    public int trap(final List<Integer> A) {
            if (A == null || A.size() == 0) {
                return 0;
            }
        int left = 0; int right = A.size() - 1;
        int maxLeft = 0; int maxRight = 0;
        int totalWater = 0;
        while (left < right) {
            if (A.get(left) < A.get(right)) {
                if (A.get(left) >= maxLeft) {
                    maxLeft = A.get(left);
                } else {
                    totalWater += maxLeft - A.get(left);
                }
                left++;
            } else {
                if (A.get(right) >= maxRight) {
                    maxRight = A.get(right);
                } else {
                    totalWater += maxRight - A.get(right);
                }
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3};
        RainWaterTrapped rainWaterTrapped = new RainWaterTrapped();
        System.out.println(rainWaterTrapped.trap(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }

}
