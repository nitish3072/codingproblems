package educative.grokkingcodinginterview.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class MinimumWindowSubstring {
  public static String findSubstring(String str, String pattern) {
    int[] patternChars = new int[65];
    for (int i = 0; i < pattern.length(); i++) {
      patternChars[pattern.charAt(i) - 'A']++;
    }
    int[] strChars = new int[65];
    int windowStart = 0;
    int min = -1;
    int max = -1;
    int smallestLength = Integer.MAX_VALUE;
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      strChars[str.charAt(windowEnd) - 'A']++;
      while (windowStart < str.length() && strChars[str.charAt(windowStart) - 'A'] > patternChars[str.charAt(windowStart) - 'A']) {
        strChars[str.charAt(windowStart) - 'A']--;
        windowStart++;
      }
      boolean satisfying = true;
      for (int i = 0; i < 65; i++) {
        if (patternChars[i] != 0 && patternChars[i] > strChars[i]) {
          satisfying = false;
          break;
        }
      }
      if (satisfying && smallestLength > windowEnd - windowStart + 1) {
        smallestLength = windowEnd - windowStart + 1;
        min = windowStart;
        max = windowEnd;
      }
    }
    if (max == -1) return "";
    else return str.substring(min, max + 1);
  }

  public static void main(String[] args) {
    System.out.println(MinimumWindowSubstring.findSubstring("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    System.out.println(MinimumWindowSubstring.findSubstring("a", "aa"));
    System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abc"));
    System.out.println(MinimumWindowSubstring.findSubstring("aabdec", "abac"));
    System.out.println(MinimumWindowSubstring.findSubstring("abdbca", "abc"));
    System.out.println(MinimumWindowSubstring.findSubstring("adcad", "abc"));
  }

}
