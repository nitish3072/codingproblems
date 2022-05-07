package leetcode.april.easy;

/**
 * https://leetcode.com/problems/word-pattern
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String s) {
        // Storing the right letters in English alphabets
        String[] alphabets = new String[126];
        String[] sArray = s.split(" ");
        if(pattern.length()!=sArray.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            if (alphabets[ch] != null && !sArray[i].equals(alphabets[ch])) {
                return false;
            } else if(alphabets[ch] == null && searchInArray(alphabets, sArray[i])) {
                return false;
            } else {
                alphabets[ch] = sArray[i];
            }
        }
        return true;
    }

    public boolean searchInArray(String[] alphabets, String searchString) {
        for (String alphabet : alphabets) {
            if (searchString.equals(alphabet))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog dog dog dog"));
    }

}
