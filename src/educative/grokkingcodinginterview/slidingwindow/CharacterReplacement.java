package educative.grokkingcodinginterview.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

  public static int findLength(String str, int k) {
    if (str == null || str.length() == 0)
      return -1;
    int[] characterList = new int[26];
    int maxLength = 0;
    int maxCount = 0;
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      maxCount = Math.max(maxCount, ++characterList[str.charAt(windowEnd) - 'a']);
      while (windowEnd - windowStart + 1 - maxCount > k) {
        characterList[str.charAt(windowStart) - 'a']--;
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(CharacterReplacement.findLength("aabccbb", 2));
    System.out.println(CharacterReplacement.findLength("abbcb", 1));
    System.out.println(CharacterReplacement.findLength("abccde", 1));
  }

}
