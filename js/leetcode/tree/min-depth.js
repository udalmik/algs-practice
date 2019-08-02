
var minDepth = function(root, curr = 0) {
    if (!root) {
        return curr;
    }
    curr++;
    if (!root.left && !root.right) {
        return curr;
    }
    const leftMin = root.left ? minDepth(root.left, curr) : Number.MAX_SAFE_INTEGER;
    const rightMin = root.right ? minDepth(root.right, curr) : Number.MAX_SAFE_INTEGER;
    return Math.min(leftMin, rightMin);
};