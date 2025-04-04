package scaler.trees_1;

import scaler.tree_common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public ArrayList<Integer> inorderTraversal(TreeNode A) {
        List<Integer> arr = new ArrayList<>();
        traverse(arr, A);
        return new ArrayList<>(arr);
    }

    void traverse(List<Integer> arr, TreeNode A) {
        if(A == null) return;
        traverse(arr, A.left);
        arr.add(A.val);
        traverse(arr, A.right);
    }

}
