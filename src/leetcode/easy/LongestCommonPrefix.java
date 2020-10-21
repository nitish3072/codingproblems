package leetcode.easy;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) {
            return "";
        }
        String longestPrefix = strs[0];
        for(String str: strs) {
            longestPrefix = longestCommonPrefix(longestPrefix, str);
        }
        return longestPrefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int p1 = 0, p2 =0;
        while (p1<str1.length() && p2<str2.length()) {
            if(str1.charAt(p1) != str2.charAt(p2)) {
                break;
            }
            p1++;p2++;
        }
        return str1.substring(0,p1);
    }

    public static void main(String[] args) {
        LongestCommonPrefix addStrings = new LongestCommonPrefix();
        String[] strs = {"flower","flow","flight"};
        System.out.println(addStrings.longestCommonPrefix(strs));
    }
}
