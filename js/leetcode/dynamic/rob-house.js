/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    const cache = new Array(nums.length).fill(-1);
    cache[0] = nums[0];
    return robHouses(nums, nums.length - 1, cache);
};

const robHouses  = (nums, idx, cache) => {
    
    if (idx < 0) return 0;

    if (cache[idx] >= 0) {
        return cache[idx];
    }
    const result = Math.max(
        robHouses(nums, idx - 1, cache),
        nums[idx] + robHouses(nums, idx - 2, cache)
    );
    cache[idx] = result;
    return result;
}

module.exports = rob;