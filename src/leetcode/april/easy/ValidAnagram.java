package leetcode.april.easy;

/**
 * https://leetcode.com/problems/valid-anagram/
 * 1) If lengths are different then return false
 * 2) Take all ascii values in an integer
 * 3) Loop for all elements of s and t
 * 4) Add 1 to ascii index value of s[i] and subract 1 to ascii index value of t[i]
 * 5) Find if any char in 255 elements is not zero
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] chars = new int[255];
        for(int i = 0; i<s.length(); i++) {
            chars[s.charAt(i)] += 1;
            chars[t.charAt(i)] -= 1;
        }
        for(int i = 0; i<255; i++) {
            if(chars[i]!=0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("rat", "car"));
    }

}
