package scaler;

public class SetBit {

    public int solve(int A, int B) {
        int ans = 1<<(A);
        ans = ans | (1<<(B));
        return ans;
    }

    public static void main(String[] args) {
        SetBit setBit = new SetBit();
        System.out.println(setBit.solve(3,5));
    }

}
