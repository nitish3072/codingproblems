package leetcode.april.easy;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 */

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] replacementChars = new int[512];
        for(int i=0;i<s.length();i++) {
            if (replacementChars[s.charAt(i)] > 0) {
                if (replacementChars[s.charAt(i)] != t.charAt(i)) {
                    return false;
                }
            } else if (replacementChars[t.charAt(i) + 256] > 0) {
                if (replacementChars[s.charAt(i)] != t.charAt(i)) {
                    return false;
                }
            } else {
                replacementChars[s.charAt(i)] = t.charAt(i);
                replacementChars[t.charAt(i) + 256] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
    }
}
