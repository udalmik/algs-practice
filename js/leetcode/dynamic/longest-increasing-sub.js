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

/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
    
    if (nums.length <= 1) return nums.length;

    const lengths = new Array(nums.length).fill(1);   
    let max = 1;
  
    for (let i = 0; i < nums.length; i++) {
        for (let j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                lengths[i] = Math.max(lengths[j] + 1, lengths[i]);
                max = Math.max(max, lengths[i]);
            }
        }
    }
    return max;
};
