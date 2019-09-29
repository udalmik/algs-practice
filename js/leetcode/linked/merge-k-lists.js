/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode[]} lists
 * @return {ListNode}
 */
var mergeKLists = function(lists) {
    if (lists.length === 0) {
        return null;
    }
    if (lists.length === 1) {
        return lists[0];
    } else if (lists.length === 2) {
        return mergeLinkedLists(lists[0], lists[1]);
    } else {
        const mid = Math.floor(lists.length/2);
        return mergeLinkedLists(
            mergeKLists(lists.slice(0, mid)), 
            mergeKLists(lists.slice(mid))
        );
    }
};

const mergeLinkedLists = (l1, l2) => {
    if (!l2) return l1;
    if (!l1) return l2;
    let head;
    let curr;
    while (l1 && l2) {
        let next;
        if (l1.val < l2.val) {
            next = l1;
            l1 = l1.next;
        } else {
            next = l2;
            l2 = l2.next;
        }
        if (!head) {
            head = curr = next;
        } else {
            curr.next = next;
            curr = next;
        }
    }

    // tail
    curr.next = l1 || l2;
    
    return head;
}