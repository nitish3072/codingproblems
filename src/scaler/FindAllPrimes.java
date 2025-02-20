package scaler;

import java.util.ArrayList;
import java.util.Arrays;

public class FindAllPrimes {

    public ArrayList<Integer> solve(int A) {
        boolean[] primes = new boolean[A + 1];
        Arrays.fill(primes, true);
        primes[1] = false;
        for(long i = 2; i < primes.length; i++) {
            if(primes[(int) i]) {
                for(long j = i * i; j < primes.length; j += i) {
                    primes[(int) j] = false;
                }
            }
        }

        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for(int i = 2; i < primes.length; i++) {
            if(primes[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

    public static void main(String[] args) {
        FindAllPrimes fp = new FindAllPrimes();
        System.out.println(fp.solve(759701));
    }
}
