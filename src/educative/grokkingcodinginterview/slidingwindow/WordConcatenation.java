package educative.grokkingcodinginterview.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordConcatenation {

  public static List<Integer> findWordConcatenation(String str, String[] words) {
    List<Integer> resultIndices = new ArrayList<Integer>();
    if (str.length() < words[0].length() * words.length) {
      return resultIndices;
    }
    Map<String, Integer> wordFrequencyMap = new HashMap<>();
    for (String word : words) {
      wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
    }
    int windowStart = 0;
    for(int windowEnd = words[0].length() * words.length - 1; windowEnd < str.length() ; windowEnd++, windowStart++) {
      Map<String, Integer> wordsSeen = new HashMap<>();
      for (int i = windowStart; i <= windowEnd; i = i + words[0].length()) {
        String strInConsideration = str.substring(i, i + words[0].length());
        if(wordFrequencyMap.containsKey(strInConsideration)) {
          wordsSeen.put(strInConsideration, wordsSeen.getOrDefault(strInConsideration, 0) + 1);
        } else {
          break;
        }
      }
      boolean allMatch = true;
      for (String word : wordFrequencyMap.keySet()) {
        if(wordsSeen.get(word)==null || !wordsSeen.get(word).equals(wordFrequencyMap.get(word))) {
          allMatch = false;
          break;
        }
      }
      if(allMatch) resultIndices.add(windowStart);
    }
    return resultIndices;
  }

  public static void main(String[] args) {
    List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
    System.out.println(result);
    result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "fox", "cat" });
    System.out.println(result);
  }

}
