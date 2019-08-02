const inorderTraversalInterative = curr => {
    
    const result = [];
    const stack = [];
    
    while (stack.length > 0 || curr) {
        if (curr && curr.left) {
            stack.push(curr);
            curr = curr.left;
            continue;
        }
        if (!curr) {
            curr = stack.pop();
        }
        result.push(curr.val);
        curr = curr.right;
    }

    return result;

};

const inorderTraversal = (root, result = []) => {

    if (!root) return result;

    if (root.left) {
        inorderTraversal(root.left, result);
    }

    result.push(root.val);

    if (root.right) {
        inorderTraversal(root.right, result);
    }

    return result;
}