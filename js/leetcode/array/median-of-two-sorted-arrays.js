/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    
    if (!nums1 || nums1.length === 0) return findArrayMedian(nums2);
    if (!nums2 || nums2.length === 0) return findArrayMedian(nums1);    
    
    const values = findMedianValues(nums1, nums2);
    
    return values.length === 1 ? values[0] : (values[0] + values[1])/2;
    
};

const findMedianValues = (nums1, nums2) => {
    
    let fIdx = 0;
    let sIdx = 0;
    
    const length = nums1.length + nums2.length;
    
    const values = [];
    const targetIndexes = length % 2 === 1 
        ? [Math.floor(length/2)]
        : [length/2 - 1, length/2];
    
    let i = 0;
    
    while (targetIndexes.length > 0) {
        
        while (i < targetIndexes[0]) {    
            if (fIdx < nums1.length && (sIdx >= nums2.length || nums1[fIdx] <= nums2[sIdx])) {
                fIdx++;
            } else {
                sIdx++;
            }
            i++;
        }

        values.push(Math.min(
            fIdx < nums1.length ? nums1[fIdx] : Number.MAX_SAFE_INTEGER, 
            sIdx < nums2.length ? nums2[sIdx] : Number.MAX_SAFE_INTEGER));

        targetIndexes.shift();
    }
    
    return values;
    
}

const findArrayMedian = nums => {
    return nums.length % 2 === 1 ? nums[Math.floor(nums.length/2)] 
        : (nums[nums.length/2 - 1] + nums[nums.length/2])/2;
}

module.exports = findMedianSortedArrays;