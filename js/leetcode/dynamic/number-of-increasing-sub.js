/**
 * @param {number[]} nums
 * @return {number}
 */
var findNumberOfLIS = function(nums) {
    const length = nums.length;
    if (length <= 1) return length;
    
    const lengths = new Array(length).fill(0);
    const counts = new Array(length).fill(1);
    
    for (let j = 0; j < length; j++) {
        for (let i = 0; i < j; i++) {
            // can contribute to new subs
            if (nums[i] < nums[j]) {
                if (lengths[i] >= lengths[j]) {
                    // increase max length for j    
                    lengths[j] = lengths[i] + 1;
                    // copy counts
                    counts[j] = counts[i];
                } else if (lengths[i] === lengths[j] - 1) {
                    counts[j] += counts[i];
                }
            }
        }    
    }
    const longest = Math.max(...lengths);
    const result = lengths.reduce((acc, curr, idx) => {
        if (curr === longest) {
            return acc + counts[idx];
        } 
        return acc;
    }, 0);
    return result;
};