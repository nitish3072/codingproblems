package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/word-pattern/
 */
public class WordPatternBijection {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        String[] patterns = pattern.split("");
        if(words.length !=patterns.length) {
            return false;
        }
        Map<String, String> letterVsWord = new HashMap<>();
        for(int i=0; i<patterns.length; i++) {
            if(letterVsWord.containsKey(patterns[i]) && !letterVsWord.get(patterns[i]).equals(words[i])) {
                return false;
            } else if(!letterVsWord.containsKey(patterns[i]) && letterVsWord.values().contains(words[i])) {
                return false;
            } else if(!letterVsWord.containsKey(patterns[i])) {
                letterVsWord.put(patterns[i], words[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
