/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
  
    const idx = binarySearch(nums, target);

    if (idx === -1) {
        return [-1, -1];
    }

    // find left index
    let leftIdx = idx;
    if (leftIdx !== 0) {
        let left = 0;
        let right = idx;
        while (left <= right) {
            const mid = Math.floor((left + right)/2);
            if (nums[mid] === target && nums[mid - 1] < target) {
                leftIdx = mid;
                break;
            } else if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }

    // find right idx
    let rightIdx = idx;
    if (idx !== nums.length - 1) {
        let left = idx;
        let right = nums.length - 1;
        while (left <= right) {
            const mid = Math.floor((left + right)/2);
            if (nums[mid] === target && nums[mid + 1] > target) {
                rightIdx = mid;
                break;
            } else if (nums[mid] <= target) {
                left = mid + 1
            } else {
                right = mid - 1;
            }
        }
    }

    return [leftIdx, rightIdx];
};


const binarySearch = (nums, target, left = 0, right = nums.length - 1) => {
    while (left <= right) {
        const mid = Math.floor((left + right)/2);
        if (nums[mid] < target) {
            left = mid + 1
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else {
            return mid;
        }
    }
    return -1;
}