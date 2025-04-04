package scaler.trees_1;

import scaler.tree_common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public ArrayList<Integer> preorderTraversal(TreeNode A) {
        List<Integer> arr = new ArrayList<>();
        traverse(arr, A);
        return new ArrayList<>(arr);
    }

    void traverse(List<Integer> arr, TreeNode A) {
        if(A == null) return;
        arr.add(A.val);
        traverse(arr, A.left);
        traverse(arr, A.right);
    }

}
