package leetcode.april.easy;

/**
 * https://leetcode.com/problems/sqrtx/
 */
public class Sqrt {

    public int mySqrt(int x) {
        long sqrt = 1;
        while ((sqrt*sqrt) <= x) {
            ++sqrt;
        }
        return (int) --sqrt;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(2147395600));
    }
}
