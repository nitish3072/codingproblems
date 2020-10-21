package leetcode.easy;

/**
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        for(char a: letters) {
            if(a > target) {
                return a;
            }
        }
        return letters[0];
    }

    public static void main(String[] args) {
        FindSmallestLetterGreaterThanTarget addStrings = new FindSmallestLetterGreaterThanTarget();
        char[] strs = {'c', 'f', 'j'};
        System.out.println(addStrings.nextGreatestLetter(strs, 'a'));
    }
}
