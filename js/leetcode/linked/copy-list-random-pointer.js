
/**
 * // Definition for a Node.
 * function Node(val,next,random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */
/**
 * @param {Node} head
 * @return {Node}
 */
var copyRandomList = function(head) {
    const copiesCache = createCopiesCache();
    const resultHead = copiesCache.getCopy(head);
    // create copies with next pointer
    let curr = head;
    let prevCopy = null;
    // copies with next
    while (curr) {
        const copy = copiesCache.getCopy(curr);
        if (prevCopy) {
            prevCopy.next = copy;
        }
        prevCopy = copy;
        curr = curr.next;
    }
    // assign randoms
    curr = resultHead;
    while (curr) {
        curr.random = copiesCache.getCopy(curr.random);
        curr = curr.next;
    }
};

const createCopiesCache = () => {
    // old -> copy
    const cache = new Map();
    return {
        getCopy: (source) => {
            if (!source) return source;
            let copy = cache.get(source);
            if (!copy) {
                copy = {
                    ...source,
                    next: null
                };
                cache.set(source, copy);
            }
            return copy;
        }
    }
}