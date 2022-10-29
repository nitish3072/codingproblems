package educative.grokkingcodinginterview.twopointer;

public class RemoveDuplicates {

  public static int remove(int[] arr) {
    int left = 0;
    for(int right = 0; right < arr.length; right++) {
      if(arr[left] != arr[right]) {
        arr[left + 1] = arr[right];
        left++;
      }
    }
    return left + 1;
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
    System.out.println(RemoveDuplicates.remove(arr));

    arr = new int[] { 2, 2, 2, 11 };
    System.out.println(RemoveDuplicates.remove(arr));
  }

}
