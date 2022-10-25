package educative.grokkingcodinginterview.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {
  public static int findLength(String str) {
    if (str == null || str.length() == 0) {
      return -1;
    }
    Map<Character, Integer> letterPositions = new HashMap<>();
    int windowStart = 0;
    int longest = 0;
    for(int windowEnd = 0; windowEnd<str.length(); windowEnd++) {
      char rightChar = str.charAt(windowEnd);
      if(letterPositions.containsKey(rightChar)) {
        windowStart = Math.max(windowStart, letterPositions.get(rightChar) + 1);
      }
      letterPositions.put(rightChar, windowEnd);
      longest = Math.max(longest, windowEnd - windowStart + 1);
    }
    return longest;
  }

  public static void main(String[] args) {
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
    System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
  }

}
