/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
const swapPairs = head => {
    let left = head;
    let prevRight = null;
    while (left && left.next) {
        const nextLeft = left.next.next;
        const right = left.next;
        right.next = left;
        left.next = null;
        if (!prevRight) {
            head = left.next;
        } else {
            prevRight.next = right;
        }
        prevRight = left;
        left = nextLeft;
    }
    return head;
}