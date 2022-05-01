package leetcode.april.easy;

/**
 * https://leetcode.com/problems/length-of-last-word
 */
public class LengthofLastWord {

    public int lengthOfLastWord(String s) {
        int lengthOfLastWord = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if(lengthOfLastWord == 0 && ch == ' ') {
                continue;
            } else if(ch == ' ') {
                break;
            } else {
                lengthOfLastWord++;
            }
        }
        return lengthOfLastWord;
    }

    public static void main(String[] args) {
        LengthofLastWord lengthofLastWord = new LengthofLastWord();
        System.out.println(lengthofLastWord.lengthOfLastWord("    Hello     World   "));
    }
}
