package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RangeSumQuery {

    public ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        int n = A.size();
        long[] prefixSum = new long[n];
        for(int i=0; i<n; i++) {
            prefixSum[i] = (i - 1 < 0) ? A.get(0) : prefixSum[i - 1] + A.get(i);
        }

        ArrayList<Long> res = new ArrayList<>();
        for(List<Integer> lr: B) {
            int l = lr.get(0);
            int r = lr.get(1);
            res.add((r==0 ? prefixSum[0] : prefixSum[r]) - (l==0 ? 0 : prefixSum[l-1]));
        }
        return res;
    }
//    [7,3,1,5,5,5,1,2,4,5]

}
