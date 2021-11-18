package leetcode.medium;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return traversal(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean traversal(TreeNode node, long max, long min) {
        if(node==null) return true;
        if(node.val<=min || node.val>=max) return false;
        return traversal(node.left, node.val, min) && traversal(node.right, max, node.val);
    }

}
