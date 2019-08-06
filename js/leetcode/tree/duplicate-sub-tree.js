/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode[]}
 */
var findDuplicateSubtrees = function(root) {

    if (!root) return [];
    
    // key -> {count, node}
    const cache = new Map();

    const collectCounts = node => {
        if (!node) return "N";
        const key = `${node.val}/${collectCounts(node.left)}/${collectCounts(node.right)}`;
        if (cache.has(key)) {
            const entry = cache.get(key);
            cache.set(key, {...entry, count: entry.count + 1});
        } else {
            cache.set(key, { node, count: 1});
        }
        return key;
    }

    collectCounts(root);

    return [...cache.entries()]
        .filter(entry => entry[1].count > 1)
        .map(entry => entry[1].node);
};

