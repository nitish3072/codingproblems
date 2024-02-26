package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static scaler.Helper.printList;

public class SumOfAllSubarrays {

    public Long subarraySum(List<Integer> A) {
        long sum = 0L;
        for (int i = 0; i < A.size(); i++) {
            sum += Long.valueOf(A.get(i)) * (long) (A.size() - i) * (long) (i + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3};
        SumOfAllSubarrays arrayRotation = new SumOfAllSubarrays();
        System.out.println(arrayRotation.subarraySum(Arrays.stream(ints).boxed().collect(Collectors.toList())));
    }

//    1,2,3,4,5
//    1 12 123 1234 12345
//    2 23 234 2345
//    3 34 345
//    4 45
//    5

//    1*5 + 2*4 + 3*3 + 4*2 + 5*1
//    2*4 + 3*3 + 4*2 + 5*1
//    3*3 + 4*2 + 5*1
//    4*2 + 5*1
//    5*1
//
//    1 * (length-i) * (i + 1)

}
