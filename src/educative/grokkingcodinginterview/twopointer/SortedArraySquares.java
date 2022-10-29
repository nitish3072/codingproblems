package educative.grokkingcodinginterview.twopointer;

public class SortedArraySquares {

  public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];
    int left = 0, right = arr.length - 1;
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[left] * arr[left] > arr[right] * arr[right]) {
        squares[i] = arr[left] * arr[left];
        left++;
      } else {
        squares[i] = arr[right] * arr[right];
        right--;
      }
    }
    return squares;
  }

  public static void main(String[] args) {
    int[] result = SortedArraySquares.makeSquares(new int[]{-2, -1, 0, 2, 3});
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();

    result = SortedArraySquares.makeSquares(new int[]{-3, -1, 0, 1, 2});
    for (int num : result)
      System.out.print(num + " ");
    System.out.println();
  }

}
