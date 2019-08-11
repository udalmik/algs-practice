/**
 * @param {number[]} nums
 * @return {number}
 */
var maxSubArray = function(nums) {
    
    let currMax = nums[0];
    let res = currMax;

    nums.forEach(n => {
        currMax = Math.max(currMax + n, n);
        if (currMax > res) {
            res = currMax;
        }
    })

    return res;
};