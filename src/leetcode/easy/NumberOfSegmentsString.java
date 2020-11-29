package leetcode.easy;

/**
 * https://leetcode.com/problems/number-of-segments-in-a-string/submissions/
 */
public class NumberOfSegmentsString {

    public int countSegments(String s) {
        if(s.length()==0) {
            return 0;
        }
        boolean previousLetterSpace = true;
        StringBuilder newS = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            // Add to new String if previous Letter is not space and current letter is Space
            if(s.charAt(i) == ' ' && !previousLetterSpace) {
                newS.append(s.charAt(i));
                previousLetterSpace = true;
            } else if(s.charAt(i) == ' ' && previousLetterSpace) {
                // Don't add to new String if previous Letter is space and current letter is also Space


            } else {
                // In all other scenarios add to new String
                newS.append(s.charAt(i));
                previousLetterSpace = false;
            }
        }
        return newS.toString().length() == 0 ? 0 : newS.toString().split(" ").length;
    }

    public static void main(String[] args) {
        NumberOfSegmentsString numberOfSegmentsString = new NumberOfSegmentsString();
        System.out.println(numberOfSegmentsString.countSegments("         "));
    }

}
