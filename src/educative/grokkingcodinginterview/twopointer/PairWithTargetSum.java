package educative.grokkingcodinginterview.twopointer;

public class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {
    int[] result = {-1, -1};
    int left = 0, right = arr.length - 1;
    while (left<right) {
      int pointerSum = arr[left] + arr[right];
      if(pointerSum == targetSum) {
        result[0] = left;
        result[1] = right;
        break;
      } else if(pointerSum > targetSum) {
        right--;
      } else {
        left++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
    System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
  }

}
