package educative.grokkingcodinginterview.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

  public static int findLength(String str, int k) {
    if (str == null || str.length() == 0) {
      return -1;
    }
    Map<Character, Integer> windowLetters = new HashMap<>();
    int windowStart = 0;
    int longest = 0;
    for(int windowEnd = 0; windowEnd<str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      windowLetters.put(rightChar, windowLetters.getOrDefault(rightChar, 0) + 1);
      while (windowLetters.size()>k) {
        char leftChar = str.charAt(windowStart++);
        if(windowLetters.get(leftChar) == 1) windowLetters.remove(leftChar);
        else windowLetters.put(leftChar, windowLetters.get(leftChar) - 1);
      }
      longest = Math.max(longest, windowEnd - windowStart + 1);
    }
    return longest;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 2));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("araaci", 1));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 3));
    System.out.println("Length of the longest substring: " + LongestSubstringKDistinct.findLength("cbbebi", 10));
  }

}
