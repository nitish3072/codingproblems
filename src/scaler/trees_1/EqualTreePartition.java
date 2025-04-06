package scaler.trees_1;

import com.sun.source.tree.Tree;
import scaler.tree_common.TreeNode;

public class EqualTreePartition {

    public int solve(TreeNode A) {
        long sum = sum(A);
        long halfSum = sum / 2;
        if (sum % 2 == 1) return 0;
        if (findHalfSumTree(A, halfSum)) return 1;
        else return 0;
    }

    public long sum(TreeNode A) {
        if (A == null) return 0;
        return A.val + sum(A.left) + sum(A.right);
    }

    public boolean findHalfSumTree(TreeNode A, long halfSum) {
        if (A == null) return false;
        if (findHalfSumTree(A.left, halfSum) || findHalfSumTree(A.right, halfSum)) return true;
        return sum(A) == halfSum;
    }

}
