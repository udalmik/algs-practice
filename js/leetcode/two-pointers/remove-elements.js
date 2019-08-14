/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    
    let left = 0;
    let right = nums.length - 1;
    let length = nums.length;
    
    nums.forEach(n => {
        if (n === val) {
            length--;
        }
    });

    while (left < right) {
        while (left < right && nums[left] !== val) {
            left++;
        }
        while (left < right && nums[right] === val) {
            right--;
        }
        if (left < right) {
            nums[left] = nums[right];
            left++;
            right--;
        }
    }
    return length;
};