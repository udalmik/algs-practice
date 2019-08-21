/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */

const nullMarker = "N";
const delimeter = ";";

var serialize = function(node, curr = "") {
    if (!node) {
        return `${curr}${nullMarker}${delimeter}`;
    }
    curr += `${node.val}${delimeter}`;
    curr = serialize(node.left, curr);
    curr = serialize(node.right, curr);
    return curr;
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function(stringData) {
    const arrayData = stringData.split(delimeter);
    const fromArray = () => {
        if (arrayData.length === 0) {
            return null;
        };
        const nodeString = arrayData.shift();
        if (nodeString === nullMarker) {
            return null;
        }
        return {
            val: Number(nodeString),
            left: fromArray(),
            right: fromArray()
        };
    }
    return fromArray();
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */