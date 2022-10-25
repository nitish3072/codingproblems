package educative.grokkingcodinginterview.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

  public static int findLength(char[] arr) {
    if (arr == null || arr.length == 0) {
      return -1;
    }
    Map<Character, Integer> windowLetters = new HashMap<>();
    int windowStart = 0;
    int longest = 0;
    for(int windowEnd = 0; windowEnd<arr.length; windowEnd++) {
      char rightChar = arr[windowEnd];
      windowLetters.put(rightChar, windowLetters.getOrDefault(rightChar, 0) + 1);
      while (windowLetters.size()>2) {
        char leftChar = arr[windowStart++];
        if(windowLetters.get(leftChar) == 1) windowLetters.remove(leftChar);
        else windowLetters.put(leftChar, windowLetters.get(leftChar) - 1);
      }
      longest = Math.max(longest, windowEnd - windowStart + 1);
    }
    return longest;
  }

  public static void main(String[] args) {
    System.out.println("Maximum number of fruits: " +
            MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
    System.out.println("Maximum number of fruits: " +
            MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
  }

}
