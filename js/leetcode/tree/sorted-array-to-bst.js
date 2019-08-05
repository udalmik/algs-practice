/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} nums
 * @return {TreeNode}
 */
var sortedArrayToBST = function(nums, start = 0, end = nums - 1) {
    
    if (start > end) {
        return null;
    }

    const mid = Math.floor((start + end) / 2);

    return {
        val: nums[mid],
        left: sortedArrayToBST(nums, start, mid - 1),
        right: sortedArrayToBST(nums, mid + 1, end)
    }

};