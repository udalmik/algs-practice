/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    
    if (!head || !head.next) return true;

    // find length

    let length = 0;
    let curr = head;
    while (curr) {
        length++;
        curr = curr.next;
    }

    // find start of right list

    let rightStart = Math.ceil(length/2);
    let right = head;
    while (rightStart > 0) {
        rightStart--;
        right = right.next;
    }

    // reverse left part
    let reverseIndex = Math.floor(length / 2);

    let prev = null;
    curr = head;

    while (reverseIndex > 0) {
        reverseIndex--;
        const temp = curr.next;
        curr.next = prev;
        prev = curr;
        curr = temp;
    }

    let left = prev;

    while (left && right) {
        if (left.val !== right.val) {
            return false;
        }
        left = left.next;
        right = right.next;
    }

    return true;
};