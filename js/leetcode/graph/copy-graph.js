/**
 * // Definition for a Node.
 * function Node(val,neighbors) {
 *    this.val = val;
 *    this.neighbors = neighbors;
 * };
 */
/**
 * @param {Node} node
 * @return {Node}
 */
var cloneGraph = function(node) {
    if (!node) return node;
    const cache = copiesCache()
    const queue = [node];
    
    const visited = new Set([node]);

    while (queue.length > 0) {
        const curr = queue.shift();
        const copy = cache.getCopy(curr);
        curr.neighbors.forEach(currentNeighbor => {
            const neighborCopy = cache.getCopy(currentNeighbor);
            copy.neighbors.push(neighborCopy);
            if (!visited.has(currentNeighbor)) {
                visited.add(currentNeighbor);
                queue.push(currentNeighbor);
            }
        });
    }

    return cache.getCopy(node);
};

const copiesCache = () => {
    const cache = new Map();
    return {
        getCopy: node => {
            let copy = cache.get(node);
            if (!copy) {
                copy = {
                    ...node,
                    neighbors: []
                };
                cache.set(node, copy)
            }
            return copy;
        }
    }
}