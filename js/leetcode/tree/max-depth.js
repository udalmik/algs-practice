/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxDepth = function(root, curr = 0) {
    if (!root) {
        return curr;
    }
    curr++;
    const left = maxDepth(root.left, curr);
    const right = maxDepth(root.right, curr);
    return Math.max(left, right);
};