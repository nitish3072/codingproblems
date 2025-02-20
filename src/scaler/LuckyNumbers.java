package scaler;

import java.util.*;

public class LuckyNumbers {

    public int solve(int A) {
        int[] spf = new int[50001];
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

        int result = 0;
        for (int i = 4 ; i<=A;i++) {
            Set<Integer> distinctPrimes = new HashSet<>();
            int number = i;
            while (number > 1) {
                distinctPrimes.add(spf[number]);
                number = number / spf[number];
            }
            if(distinctPrimes.size()==2) result++;
        }

        return result;
    }

    public static void main(String[] args) {
        LuckyNumbers luckyNumbers = new LuckyNumbers();
        luckyNumbers.solve(12);
    }
}
