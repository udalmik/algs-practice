/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    if (nums.length === 0) return 0;
    if (nums.length === 1) {
        return nums[0] < target ? 1 : 0;
    } 
    let start = 0;
    let end = nums.length - 1;
    while (start <= end) {
        const mid = Math.floor(start + (end - start)/2);
        if (target === nums[mid]) {
            return mid;
        } else if (target > nums[mid]) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return start;
};
