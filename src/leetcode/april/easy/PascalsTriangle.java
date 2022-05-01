package leetcode.april.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * 1) First iterate through the number of Rows
 * 2) First and last element of the row is always one
 * 3) For every 'i' in current list the value will be sum of 'i-1' and 'i' in previous list above it
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> internalList = new ArrayList<>();
            List<Integer> previousList = list.size()==0 ? new ArrayList<>() : list.get(list.size()-1);
            for (int j = 0; j < i + 1; j++) {
                if (j==0 || j==i) { internalList.add(1); continue; }
                internalList.add(previousList.get(j-1) + previousList.get(j));
            }
            list.add(internalList);
        }
        return list;
    }

    public static void main(String[] args) {
        PascalsTriangle pascalsTriangle = new PascalsTriangle();
        List<List<Integer>> list = pascalsTriangle.generate(5);
        System.out.println(list);
    }
}
