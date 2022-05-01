package leetcode.april.easy;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle-ii/
 * 1) Make an array of desired size + 1. Because: Index 0 has 1 element, Index 1 has 2 elements and so on
 * 2) Fill complete array with zeros
 * 3) Now start making every row by iterating from 0 to rowIndex
 * 4) We start calculating each row from behind because the formula(arr[j] = arr[j] + arr[j-1]) shows
 * that j-1 needs to be intact as previous row's element. If we start from beginning it will change as j-1 will be implemented before j
 */
public class PascalsTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        Integer[] arr = new Integer[rowIndex+1];
        Arrays.fill(arr, 0);
        for(int i=0; i<=rowIndex; i++) {
           for(int j=i; j>=0; j--) {
               if (j==0 || j==i) { arr[j] = 1; continue; }
               arr[j] = arr[j] + arr[j-1];
           }
        }
        return Arrays.asList(arr);
    }

    public static void main(String[] args) {
        PascalsTriangle2 pascalsTriangle = new PascalsTriangle2();
        List<Integer> list = pascalsTriangle.getRow(1);
        System.out.println(list);
    }
}
