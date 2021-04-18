package leetcode.easy;

/**
 * https://leetcode.com/problems/check-if-n-and-its-double-exist/submissions/
 */
public class CheckNandDoubleExist {

    public boolean checkIfExist(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                if(arr[i] == 2*arr[j] || 2*arr[i]==arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckNandDoubleExist checkNandDoubleExist = new CheckNandDoubleExist();
        int[] arr = {-2, 4, 2, 6, 9, 10};
        System.out.println(checkNandDoubleExist.checkIfExist(arr));

    }
}
