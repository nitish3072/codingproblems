package leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/most-frequent-subtree-sum/submissions/
 */
public class DFSMostFrequentSubtreeSum {

    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumArrayFrequency = new HashMap<>();
        dfs(root, sumArrayFrequency);

        List<Integer> maxFreqSum = new ArrayList<>();
        for(Integer sum: sumArrayFrequency.keySet()) {
            if(sumArrayFrequency.get(sum) == maxCount) {
                maxFreqSum.add(sum);
            }
        }
        return maxFreqSum.stream().mapToInt(i->i).toArray();
    }

    public int dfs(TreeNode node, Map<Integer, Integer> sumArrayFrequency) {
        if(node==null) {
            return 0;
        }
        int sum = dfs(node.left, sumArrayFrequency) + dfs(node.right, sumArrayFrequency) + node.val;
        sumArrayFrequency.put(sum, sumArrayFrequency.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, sumArrayFrequency.get(sum));
        return sum;
    }

    public static void main(String[] args) {
        DFSMostFrequentSubtreeSum dfsMostFrequentSubtreeSum = new DFSMostFrequentSubtreeSum();
        TreeNode treeNode4 = new TreeNode(4, null, null);
        TreeNode treeNode6 = new TreeNode(6, null, null);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode6);
        TreeNode treeNode1 = new TreeNode(1, null, null);
        TreeNode treeNode21 = new TreeNode(2, null, null);
        TreeNode treeNode3 = new TreeNode(-3, treeNode21, treeNode1);
        TreeNode treeNode5 = new TreeNode(5, treeNode2, treeNode3);
        System.out.println(Arrays.toString(dfsMostFrequentSubtreeSum.findFrequentTreeSum(treeNode5)));
    }

}

class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
