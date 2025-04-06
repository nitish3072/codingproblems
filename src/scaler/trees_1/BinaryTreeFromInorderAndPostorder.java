package scaler.trees_1;

import scaler.tree_common.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreeFromInorderAndPostorder {

    public TreeNode buildTree(List<Integer> A, List<Integer> B) {
        TreeNode res =  buildBinarySearchTree(A, B, 0, A.size() - 1, 0, B.size() - 1);
        return res;
    }

    public TreeNode buildBinarySearchTree(List<Integer> A, List<Integer> B, int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return null;
        int head = B.get(pe);
        TreeNode root = new TreeNode(head);
        int headIdxInOrder = -1;
        for (int i = is; i <= ie; i++) {
            if (A.get(i) == head) {
                headIdxInOrder = i;
                break;
            }
        }
        if (headIdxInOrder == -1) return null;
        int postOrderIdx = ps + headIdxInOrder - is;
        root.left = buildBinarySearchTree(A, B, is, headIdxInOrder - 1, ps, postOrderIdx - 1);
        root.right = buildBinarySearchTree(A, B, headIdxInOrder + 1, ie, postOrderIdx, pe - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] ints1 = new int[]{7,5,6,2,3,1,4};
        int[] ints2 = new int[]{5,6,3,1,4,2,7};
        BinaryTreeFromInorderAndPostorder sortedInsertPosition = new BinaryTreeFromInorderAndPostorder();
        System.out.println(sortedInsertPosition.buildTree(Arrays.stream(ints1).boxed().collect(Collectors.toList()), Arrays.stream(ints2).boxed().collect(Collectors.toList())));
    }


}
