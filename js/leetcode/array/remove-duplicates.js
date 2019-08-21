/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {

    if (nums.length <= 1) return nums.length;

    let slow = 0;
    let fast = 0;

    while (fast < nums.length) {
        while (fast < nums.length && nums[slow] === nums[fast]) {
            fast++;
        }
        if (fast < nums.length) {
            slow++;
            nums[slow] = nums[fast];
            fast++;
        }
    }

    return slow + 1;
    
};