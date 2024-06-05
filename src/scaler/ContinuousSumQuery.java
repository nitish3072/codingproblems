package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContinuousSumQuery {

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        int[] res = new int[A + 1];
        for(int i=0; i < B.size(); i++) {
            res[B.get(i).get(0)-1] += B.get(i).get(2);
            res[B.get(i).get(1)] -= B.get(i).get(2);
        }
        for(int i=1; i < B.size(); i++) {
            res[i] = res[i-1] + res[i];
        }

        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < res.length - 1; i++) {
            int re = res[i];
            resultList.add(re);
        }
        return resultList;
    }

}
