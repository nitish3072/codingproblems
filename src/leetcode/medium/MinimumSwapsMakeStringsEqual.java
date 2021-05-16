package leetcode.medium;

/**
 * https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/
 */
public class MinimumSwapsMakeStringsEqual {

    public int minimumSwap(String s1, String s2) {
        if(s1.length()!=s2.length()) {
            return -1;
        }
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        for(int i = 0; i<s2.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if(c1 == c2){ // skip chars that are equal at the same index in s1 and s2
                continue;
            }
            if(c1=='x') {
               x1 += 1;
            } else {
                y1 += 1;
            }
            if(c2=='x') {
                x2 += 1;
            } else {
                y2 += 1;
            }
        }
        if((x1+x2)%2!=0 || (y1+y2)%2!=0) {
            return -1;
        }
        int swaps = x1 / 2 + y1 / 2 + (x1 % 2) * 2;
        return swaps;
    }

    public static void main(String[] args) {
        MinimumSwapsMakeStringsEqual minimumSwapsMakeStringsEqual = new MinimumSwapsMakeStringsEqual();
        System.out.println(minimumSwapsMakeStringsEqual.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }
}
