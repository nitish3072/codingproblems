package algoxpert.arrays;

import java.util.List;

/**
 * https://www.algoexpert.io/questions/validate-subsequence
 */
public class ValidSubsequenceEasy {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int sequenceIndex = 0;
        for (int i = 0; i < array.size(); i++) {
            if (sequenceIndex > sequence.size() - 1) break;
            if (array.get(i).equals(sequence.get(sequenceIndex))) sequenceIndex++;
        }
        if (sequenceIndex >= sequence.size()) return true;
        else return false;
    }

    public boolean isSubsequence(String s, String t) {
        int sequenceIndex = 0;
        for (int i = 0; i < t.length(); i++) {
            if (sequenceIndex > s.length() - 1) break;
            if (t.charAt(i) == s.charAt(sequenceIndex)) sequenceIndex++;
        }
        if (sequenceIndex >= s.length()) return true;
        else return false;
    }

}
