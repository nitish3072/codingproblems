package leetcode.easy;

/**
 * https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
 */
public class ReplaceAllQuestionMarkToAvoidConsecutiveRepeatingCharacters {

    public String modifyString(String s) {
        int charStart = 'a';
        String newString = "";
        for(int i=0; i<s.length();i++) {
            if(s.charAt(i) == '?' && i==0 && s.length()==1) {
                newString = newString + (char) charStart;
            } else if(s.charAt(i) == '?' && i==0) {
                newString = newString + (char) (charStart==s.charAt(i+1) ? ++charStart: charStart);
            } else if(s.charAt(i) == '?' && i==s.length()-1) {
                newString = newString + (char) (charStart==newString.charAt(i-1) ? ++charStart: charStart);
            } else if(s.charAt(i) == '?') {
                if(charStart==newString.charAt(i-1) || (charStart + 1)==s.charAt(i+1)) {
                    charStart = charStart + 2;
                } else if(charStart==s.charAt(i+1) || (charStart + 1)==newString.charAt(i-1)) {
                    charStart = charStart + 2;
                } else {
                    charStart = charStart + 1;
                }
                newString = newString + (char) charStart;
            } else {
                newString = newString + s.charAt(i);
            }
            charStart ++ ;
        }
        return newString;
    }

    public static void main(String[] args) {
        ReplaceAllQuestionMarkToAvoidConsecutiveRepeatingCharacters addStrings = new ReplaceAllQuestionMarkToAvoidConsecutiveRepeatingCharacters();
        System.out.println(addStrings.modifyString("j?qg??b"));
    }
}
