/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    if (nums.length === 1) {
        return nums[0] === target ? 0 : -1;
    }
    
    let start = 0;
    let end = nums.length - 1;
    
    if (nums[start] <= nums[end]) {
        return binarySearch(nums, start, end, target);
    }
    
    // find rotation
    let idx = 0;
    while (start <= end) {
        const mid = Math.floor(start + (end - start)/2);
        if (nums[mid] > nums[mid + 1]) {
            idx = mid;
        }
        if (nums[start] > nums[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    
    if (nums[idx] === target) return idx;

    return Math.max(
        binarySearch(nums, 0, idx, target),
        binarySearch(nums, idx + 1, nums.length - 1, target)
    )
};


const binarySearch = (nums, start, end, target) => {
    while (start <= end) {
        const mid = Math.floor(start + (end - start)/2);
        if (nums[mid] === target) {
            return mid;
        }
        if (nums[mid] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return -1;
}