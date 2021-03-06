
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 */
const twoSum = (nums, target) => {
    const map = {};
    let result = [];
    nums.forEach((n, idx) => {
        const diff = target - n;
        const key = diff.toString();
        if (map[key] !== undefined) {
            result = [idx, map[key][1]];
            return false;
        }
        map[n.toString()] = [n, idx];
        return true;
    });
    return result;
};