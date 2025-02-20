package scaler;

import java.util.*;

public class Countofdivisors {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int[] spf = new int[1000001];
        Arrays.fill(spf, 1);
        spf[1] = 1;
        spf[2] = 2;
        spf[3] = 3;
        for (long i = 2; i < spf.length; i++) {
            if (spf[(int) i] == 1) spf[(int) i] = (int) i;
            for (long j = i * i; j < spf.length; j += i) {
                if (spf[(int) j] == 1) spf[(int) j] = (int) i;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer i : A) {
            Map<Integer, Integer> map = new HashMap<>();
            while (i > 1) {
                map.put(spf[i], map.getOrDefault(spf[i], 0)+1);
                i = i / spf[i];
            }
            int sum = 1;
            for(Integer primeFactor: map.keySet()) {
                sum = sum * (map.get(primeFactor) + 1);
            }
            result.add(sum);
        }
        return result;
    }


    public static void main(String[] args) {
        Countofdivisors countofdivisors = new Countofdivisors();
        List<Integer> list = Arrays.asList(8, 9, 10);
        countofdivisors.solve(new ArrayList<>(list));
    }
}
