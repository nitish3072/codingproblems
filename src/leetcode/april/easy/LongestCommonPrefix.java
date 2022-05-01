package leetcode.april.easy;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int minimumLength = smallest(strs);
        for (int i = 0; i < minimumLength; i++) {
            char currentAlphabet = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                char ch = strs[j].charAt(i);
                if(ch!=currentAlphabet) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minimumLength);
    }

    public int smallest(String[] words) {
        if (words == null || words.length < 1) {
            return 0;
        }
        String smallest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < smallest.length()) {
                smallest = words[i];
            }
        }
        return smallest.length();
    }// smallest

    public static void main(String[] args) {
        String[] strings = {"dog","dogga","do"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(strings));
    }

}
