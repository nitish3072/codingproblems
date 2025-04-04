package scaler.trees_1;

import scaler.tree_common.TreeNode;

public class PathSum {

    public int hasPathSum(TreeNode A, int B) {
        if(sum(A, B, 0)) return 1;
        else return 0;
    }

    public boolean sum(TreeNode A, int B, int currSum) {
        if(A == null) return false;
        currSum += A.val;
        if(A.left == null && A.right == null && currSum == B) return true;
        return sum(A.left, B, currSum) || sum(A.right, B, currSum);
    }

}
