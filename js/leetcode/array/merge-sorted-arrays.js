/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
const merge = (nums1, m, nums2, n) => {
  
    let tailIdx = n + m - 1;

    let tailIdx1 = m - 1;

    let tailIdx2 = n - 1;

    while (tailIdx1 >= 0 && tailIdx2 >= 0) {
        
        if (nums1[tailIdx1] > nums2[tailIdx2]) {
            nums1[tailIdx--] = nums1[tailIdx1--];
        }
        else {
            nums1[tailIdx--] = nums2[tailIdx2--];
        }
    }

    while (tailIdx2 >= 0) {
        nums1[tailIdx--] = nums2[tailIdx2--];
    }
};