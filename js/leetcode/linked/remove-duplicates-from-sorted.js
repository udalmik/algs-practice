/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var deleteDuplicates = function(head) {

    if (!head || !head.next) return head;
    
    let slow = head;
    let fast = head;

    while (fast) {
        while (fast && fast.val === slow.val) {
            fast = fast.next;
        }
        if (fast) {
            slow.next = fast;
            slow = slow.next;
            fast = fast.next;
        }
    }

    if (slow) {
        slow.next = null;
    }

    return head;

};