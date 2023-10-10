package algoxpert.arrays;

/**
 * https://www.algoexpert.io/questions/sorted-squared-array
 */
public class SortedSquaredArrayEasy {

    public int[] sortedSquaredArray(int[] arr) {
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

}
