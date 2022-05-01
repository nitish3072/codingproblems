package leetcode.april.easy;

/**
 * https://leetcode.com/problems/single-number/
 * 1) Using XOR all the duplicates become zero and only the single one remains
 * XOR is bitwise operator. If bit is same it give zero(false) and if bits are different it gives one(true)
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] arr = {1,2,4,1,2};
        System.out.println(singleNumber.singleNumber(arr));
    }

}
