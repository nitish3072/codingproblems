package leetcode.april.easy;

/**
 * https://leetcode.com/problems/first-unique-character-in-a-string
 * 1) Keep track of counts of all alphabets in string s
 * 2) Then iterate s again from start and check if any character is appearing only once
 */
public class FirstUniqueCharacterString {

    public int firstUniqChar(String s) {
        int[] alphabets = new int[26];
        for (int i = 0; i < s.length(); i++) alphabets[s.charAt(i) - 97] += 1;
        for (int i = 0; i < s.length(); i++) if (alphabets[s.charAt(i) - 97] == 1) return i;
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterString firstUniqueCharacterString = new FirstUniqueCharacterString();
        System.out.println(firstUniqueCharacterString.firstUniqChar("loveleetcode"));
    }
}
