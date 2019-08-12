/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    if (!l1) {
        return l2;
    }
    if (!l2) {
        return l1;
    }

    let res = null;
    let curr = null;

    while (l1 && l2) {
        let nextNode;
        if (l1.val < l2.val) {
            nextNode = l1;
            l1 = l1.next;
        } else {
            nextNode = l2;
            l2 = l2.next;
        }
        if (!res) {
            res = nextNode;
            curr = nextNode;
        } else {
            curr.next = nextNode;
            curr = nextNode;
        }
        l1 = l1.next;
        l2 = l2.next;
    }
    if (l1) {
        curr.next = l1;
    }
    if (l2) {
        curr.next = l2;
    }

    return res;

};