package scaler.searching_1_binary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Findpeakelement {

    public int solve(List<Integer> A) {
        if(A.size() == 1) return A.get(0);
        int s = 0, e = A.size() - 1, mid = 0, index = -1;
        while (s <= e) {
            mid = (s + e) / 2;
            if(mid - 1 < 0) {
                if (A.get(mid) >= A.get(mid + 1)) index = mid;
                else index = mid + 1;
                break;
            }
            if(mid + 1 >= A.size()) {
                if (A.get(mid) >= A.get(mid - 1)) index = mid;
                else index = mid - 1;
                break;
            }
            if (A.get(mid)>=A.get(mid - 1) && A.get(mid)>=A.get(mid + 1)) {
                index = mid;
                break;
            } else if (A.get(mid)<=A.get(mid - 1) && A.get(mid)>=A.get(mid + 1)) {
                e = mid - 1;
            } else if (A.get(mid)>=A.get(mid - 1) && A.get(mid)<=A.get(mid + 1)) {
                s = mid + 1;
            }
        }
        return A.get(index);
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,1000000000,1000000000};
        Findpeakelement sortedInsertPosition = new Findpeakelement();
        System.out.println(sortedInsertPosition.solve(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }

}
