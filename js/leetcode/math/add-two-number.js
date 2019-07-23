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
const addTwoNumbers = function(l1, l2) {
    let head = current = null;
    let remainder = false;
    while (l1 || l2) {
        const firstVal = l1 ? l1.val : 0;
        const secondVal = l2 ? l2.val : 0;
        let value = firstVal + secondVal + (remainder ? 1 : 0);
        if (value >= 10) {
            remainder = true;
            value -= 10;
        } else {
            remainder = false;
        }
        const node = {
            val: value,
            next: null
        };
        if (!head) {
            head = current = node;
        } else {
            current.next = node;
            current = current.next;
        }
        if (l1) {
            l1 = l1.next;
        }
        if (l2) {
            l2 = l2.next;
        }
    }
    if (remainder) {
        current.next = {
            val: 1
        }
    }
    return head;
};

module.exports = {
    addTwoNumbers
}
