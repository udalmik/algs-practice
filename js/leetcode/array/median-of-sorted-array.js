/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function(nums1, nums2) {
    return 1;
};

const arraysProjection = (nums1, nums2) => {

    if (nums1.length === 0) return simpleProjection(nums2);
    if (nums2.length === 0) return simpleProjection(nums1);
    if (nums1[0] <= nums2[0] && nums1[nums1.length - 1] >= nums2[nums2.length - 1]) return simpleProjection(nums1);
    if (nums2[0] <= nums1[0] && nums2[nums2.length - 1] >= nums1[nums1.length - 1]) return simpleProjection(nums2);
    
    // need a merged projection

    return {
        length: 0,
        get: idx => {
            return 0;
        }
    }
}

const simpleProjection = arr => {
    return {
        length: arr.length,
        get: i => arr[i]
    };
}