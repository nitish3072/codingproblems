package scaler;

import java.util.ArrayList;

public class FindPrime {

    public boolean solve(int A) {
        if(A==1) return false;
        int numberOfFactors = 0;
        for(int i = 1; i <= (int) Math.sqrt(A); i++) {
            if(A%i==0) numberOfFactors = numberOfFactors + 2;
        }
        return numberOfFactors==2;
    }

    public static void main(String[] args) {
        FindPrime fp = new FindPrime();
        System.out.println(fp.solve(9));
    }

}
