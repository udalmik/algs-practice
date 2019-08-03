
var isSameTree = function(n1, n2) {
    if (!n1 && !n2) return true;
    if (!n1) return false;
    if (!n2) return false;
    return (n1.val === n2.val) 
        && isSameTree(n1.left, n2.left)
        && isSameTree(n1.right, n2.right);
};
