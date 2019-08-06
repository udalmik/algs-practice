/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function(root, res = []) {
    
    if (!root) return res;
    
    postorderTraversal(root.left, res);
    postorderTraversal(root.right, res);

    res.push(root.val);

    return res;
};