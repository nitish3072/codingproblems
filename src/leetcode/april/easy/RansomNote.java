package leetcode.april.easy;

/**
 * https://leetcode.com/problems/ransom-note/
 * 1) Store count of alphabets from magazine in magazineAlphabets
 * 2) Negate count of alphabets from ransomNote in magazineAlphabets
 * 3) If in magazineAlphabets any index is less than 0 then its not possible Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineAlphabets = new int[26];
        for (int i = 0; i < magazine.length(); i++) magazineAlphabets[magazine.charAt(i)-97] += 1;
        for (int i = 0; i < ransomNote.length(); i++) magazineAlphabets[ransomNote.charAt(i)-97] -= 1;
        for (int magazineAlphabet : magazineAlphabets) if (magazineAlphabet < 0) return false;
        return true;
    }

    public static void main(String[] args) {
        RansomNote ransomNote = new RansomNote();
        System.out.println(ransomNote.canConstruct("aa", "ab"));
    }

}
