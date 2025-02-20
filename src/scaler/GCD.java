package scaler;

public class GCD {
    public static int gcd(int A, int B) {
        if(B==0) {
            return A;
        }
        return gcd(B,A%B);
    }

    public static void main(String[] args) {
        GCD gcd = new GCD();
        System.out.println(gcd.gcd(10, 20));
    }
}
