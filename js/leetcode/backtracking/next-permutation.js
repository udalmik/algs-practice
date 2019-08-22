/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
    // find position when i el is greater than i + 1
    let i = 0;
    for (i = nums.length - 1; i > 0; i--) {
        if (nums[i] > nums[i - 1]) {
            break;
        }
    }
    if (i === 0) {
        return nums.sort((a, b) => a - b);
    }
    let min = Number.MAX_SAFE_INTEGER;
    let index = 0;
    let j = i;
    for (; j < nums.length; j++) {
        if (nums[j] > nums[i - 1] && min > nums[j]) {
            index = j;
            min = nums[j];
        }
    }
    const temp = nums[i - 1];
    nums[i - 1] = nums[index];
    nums[index] = temp;
    const left = nums.slice(0, i);
    const right = nums.slice(i).sort((a, b) => a - b);
    
    return [...left, ...right];
};

module.exports = nextPermutation;