/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrder = function(root, res = [], level = 0) {
    
    if (!root) return res;

    if (!res[level]) {
        res[level] = [];
    }

    res[level].push(root.val);

    levelOrder(root.left, res, level + 1);
    levelOrder(root.right, res, level + 1);

    return res;
};