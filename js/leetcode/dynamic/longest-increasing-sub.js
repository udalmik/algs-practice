/**
 * @param {number[]} nums
 * @return {number}
 */
var findLengthOfLCIS = function(nums) {
    const length = nums.length;
    if (length <= 1) return length;
    
    let max = 1;
    let count = 1;
    for (let i = 1; i < length; i++) {
        if (nums[i] > nums[i - 1]) {
            count++;
        } else {
            count = 1;
        }
        max = Math.max(count, max);
    }

    return max;
};
