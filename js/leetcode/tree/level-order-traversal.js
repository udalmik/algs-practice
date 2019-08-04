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

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var averageOfLevels = function(root) {
    return levelOrder(root).map(avg);
};

const avg = arr => {
    const count = arr.length;
    const sum = arr.reduce((prev, curr) => prev + curr, 0);
    return sum / count;
}

/**
 * @param {TreeNode} root
 * @return {number[][]}
 */
var levelOrderBottom = function(root) {
    return levelOrder(root).reverse();
};