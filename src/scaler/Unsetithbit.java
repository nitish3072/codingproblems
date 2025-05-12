package scaler;

public class Unsetithbit {

    public int solve(int A, int B) {
        if((A & (1<<B)) != 0) {
            return (A | (1<<B));
        }
        return A;
    }

    public static void main(String[] args) {
        Unsetithbit unsetithbit = new Unsetithbit();
        System.out.println(unsetithbit.solve(4,1));
    }
}
