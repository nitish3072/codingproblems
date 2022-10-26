package educative.grokkingcodinginterview.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class StringAnagrams {

  public static List<Integer> findStringAnagrams(String str, String pattern) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    int[] patternChars = new int[26];
    for (int i = 0; i < pattern.length(); i++) {
      patternChars[pattern.charAt(i) - 'a']++;
    }
    int[] strChars = new int[26];
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
      strChars[str.charAt(windowEnd) - 'a']++;
      while (windowStart < str.length() && strChars[str.charAt(windowStart) - 'a'] > patternChars[str.charAt(windowStart) - 'a']) {
        strChars[str.charAt(windowStart) - 'a']--;
        windowStart++;
      }
      boolean satisfying = true;
      for(int i = 0; i<26; i++) {
        if(patternChars[i]!=strChars[i]) {
          satisfying = false;
        }
      }
      if(satisfying) resultIndices.add(windowStart);
    }
    return resultIndices;
  }

  public static void main(String[] args) {
    System.out.println(StringAnagrams.findStringAnagrams("ppqp", "pq"));
    System.out.println(StringAnagrams.findStringAnagrams("abbcabc", "abc"));
  }

}
