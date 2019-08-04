/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {boolean}
 */
var isSymmetric = function(root) {
    if (!root) return true;
    return isSymmetricNode(root.left, root.right);
};

var isSymmetricNode = function(n1, n2) {
    if (!n1 && !n2) return true;
    if (!n1) return false;
    if (!n2) return false; 
    return (n1.val === n2.val)
        && isSymmetricNode(n1.left, n2.right)
        && isSymmetricNode(n1.right, n2.left);
}
