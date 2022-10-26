package educative.grokkingcodinginterview.slidingwindow;

public class StringPermutation {

  public static boolean findPermutation(String str, String pattern) {
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
      if(satisfying) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf", "abc"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf", "dc"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy", "bcdyabcdx"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb", "abc"));
    System.out.println("Permutation exist: " + StringPermutation.findPermutation("b", "a"));
  }

}
