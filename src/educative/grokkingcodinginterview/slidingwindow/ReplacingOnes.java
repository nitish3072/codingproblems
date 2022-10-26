package educative.grokkingcodinginterview.slidingwindow;

public class ReplacingOnes {

  public static int findLength(int[] arr, int k) {
    if(arr.length==0) {
      return -1;
    }
    int zeroesInWindow = 0;
    int windowStart = 0;
    int maxLength = 0;
    for(int windowEnd =0; windowEnd<arr.length; windowEnd++) {
      if(arr[windowEnd]==0) zeroesInWindow++;
      while (zeroesInWindow > k) {
        if(arr[windowStart]==0) zeroesInWindow--;
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1 }, 2));
    System.out.println(ReplacingOnes.findLength(new int[] { 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1 }, 3));
  }

}
