package com.udalmik.algs.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

// (a) In order (Left, Root, Right) : 4 2 5 1 3
// no recursion
public class InOrderTraversal {

    public ArrayList<Integer> inorderTraversal(TreeNode root) {

        final ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return result;
        }

        Stack<StackNode> path = new Stack<>();
        path.push(new StackNode(false, root));

        while (!path.isEmpty()) {
            final StackNode stackNode = path.pop();
            final TreeNode treeNode = stackNode.node;
            if (treeNode.right == null && treeNode.left == null) {
                result.add(treeNode.val);
            } else if (stackNode.popFromLeft) {
                // pop from left
                result.add(treeNode.val);
                if (treeNode.right != null) {
                    path.push(new StackNode(false, treeNode.right));
                }
            } else if (treeNode.left != null) {
                path.push(new StackNode(true, treeNode));
                path.push(new StackNode(false, treeNode.left));
            } else {
                // only right
                result.add(treeNode.val);
                path.push(new StackNode(false, treeNode.right));
            }
        }

        return result;
    }

}

class StackNode {

    boolean popFromLeft;
    TreeNode node;

    public StackNode(boolean popFromLeft, TreeNode node) {
        this.popFromLeft = popFromLeft;
        this.node = node;
    }
}

