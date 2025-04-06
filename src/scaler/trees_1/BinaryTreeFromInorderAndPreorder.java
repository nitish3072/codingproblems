package scaler.trees_1;

import scaler.tree_common.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryTreeFromInorderAndPreorder {

    public TreeNode buildTree(List<Integer> A, List<Integer> B) {
        TreeNode res =  buildBinarySearchTree(A, B, 0, A.size() - 1, 0, B.size() - 1);
        return res;
    }

    public TreeNode buildBinarySearchTree(List<Integer> A, List<Integer> B, int ps, int pe, int is, int ie) {
        if (is > ie || ps > pe) return null;
        int head = A.get(ps);
        TreeNode root = new TreeNode(head);
        int headIdxInOrder = -1;
        for (int i = is; i <= ie; i++) {
            if (B.get(i) == head) {
                headIdxInOrder = i;
                break;
            }
        }
        if (headIdxInOrder == -1) return null;
        int preOrderIdx = ps + headIdxInOrder - is;
        root.left = buildBinarySearchTree(A, B, ps + 1, preOrderIdx, is, headIdxInOrder - 1);
        root.right = buildBinarySearchTree(A, B, preOrderIdx + 1, pe, headIdxInOrder + 1, ie);
        return root;
    }

    public static void main(String[] args) {
        int[] ints1 = new int[]{1, 6, 2, 3};
        int[] ints2 = new int[]{6, 1, 3, 2};
        BinaryTreeFromInorderAndPreorder sortedInsertPosition = new BinaryTreeFromInorderAndPreorder();
        System.out.println(sortedInsertPosition.buildTree(Arrays.stream(ints1).boxed().collect(Collectors.toList()), Arrays.stream(ints2).boxed().collect(Collectors.toList())));
    }


}
