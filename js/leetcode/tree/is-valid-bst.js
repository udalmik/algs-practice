const isValidBST = (root, min = Number.POSITIVE_INFINITY, max = 0) => {    
    if (!root) return true;
    if (root < min) return false;
    if (root > max) return false;
    return isValidBST(root.left, Math.min(min, root), max) 
                && isValidBST(root.right, min, Math.max(root, max));
};