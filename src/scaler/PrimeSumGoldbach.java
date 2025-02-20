package scaler;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeSumGoldbach {
    public ArrayList<Integer> primesum(int A) {
        boolean[] isPrime = new boolean[A + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        for(long i = 2; i < isPrime.length; i++) {
            if(isPrime[(int) i]) {
                for(long j = i * i; j < isPrime.length; j += i) {
                    isPrime[(int) j] = false;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i<isPrime.length;i++) {
            if(isPrime[i] && isPrime[(A - i)]) {
                result.add(i);
                result.add(A-i);
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        PrimeSumGoldbach primeSumGoldbach = new PrimeSumGoldbach();
        primeSumGoldbach.primesum(22);
    }

}
