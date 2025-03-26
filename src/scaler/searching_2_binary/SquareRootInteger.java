package scaler.searching_2_binary;

public class SquareRootInteger {

    public int sqrt(int A) {
        if(A <= 1) return A;
        int s = 0, e = A, mid = 0;
        int ans = 0;
        while (s <= e) {
            mid = (e - s) / 2 + s;
            long sqr = (long) mid * mid;
            if (sqr == A) {
                ans = mid;
                break;
            } else if (sqr > A) {
                e = mid - 1;
            } else {
                s = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SquareRootInteger sortedInsertPosition = new SquareRootInteger();
        System.out.println(sortedInsertPosition.sqrt(2147483647));
    }

}
