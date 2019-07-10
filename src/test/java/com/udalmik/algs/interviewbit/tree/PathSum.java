package com.udalmik.algs.interviewbit.tree;

/**
 * https://www.interviewbit.com/problems/path-sum/
 */
public class PathSum {

    public int hasPathSum(TreeNode root, int sum) {
        return hasSum(0, root, sum) ? 1 : 0;
    }

    private boolean hasSum(int current, TreeNode node, int sum) {

        if (node == null)
            return false;

        final int currentSum = current + node.val;

        boolean isLeafWithSum = isLeaf(node) && currentSum == sum;
        boolean leftHashSum = hasSum(currentSum, node.left, sum);
        boolean rightHashSum = hasSum(currentSum, node.right, sum);

        return isLeafWithSum || leftHashSum || rightHashSum;

    }

    boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}