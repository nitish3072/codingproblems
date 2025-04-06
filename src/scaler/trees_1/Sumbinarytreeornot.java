package scaler.trees_1;

import scaler.tree_common.TreeNode;

public class Sumbinarytreeornot {

    public int solve(TreeNode A) {
        if(A == null) return 1;
        if(sumBinaryTree(A)) return 1;
        else return 0;
    }

    public long sum(TreeNode A) {
        if (A == null) return 0;
        return A.val + sum(A.left) + sum(A.right);
    }

    public boolean sumBinaryTree(TreeNode A) {
        if(A == null) return true;
        if(A.left == null && A.right == null) return true;
        long sum = sum(A.left) + sum(A.right);
        if(sumBinaryTree(A.left) && sumBinaryTree(A.right) && sum == A.val) return true;
        else return false;
    }


}
