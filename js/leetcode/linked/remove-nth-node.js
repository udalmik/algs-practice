/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    if (n === 0) return head;
    if (!head.next && n === 1) {
        return null;
    }
    let curr = head;
    let count = 0;
    while (curr) {
        count++;
        curr = curr.next;
    }
    if (count === n) {
        return head.next;
    }
    let position = count - n;
    curr = head;
    while (position > 1) {
        curr = curr.next;
        position--;
    }
    if (curr.next) {
        curr.next = curr.next.next;
    }
    return head;
};