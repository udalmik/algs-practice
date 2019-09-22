/**
 * @param {number} x
 * @return {number}
 */
const mySqrt = x => {
    
    if (x <= 1) {
        return x;
    }
    
    let l = 1;
    let r = x;
    
    while (l <= r) {
        const mid = l + Math.floor((r - l)/2);
        if (mid > x / mid) {
            r = mid - 1;
        } else if ((mid + 1) > x / (mid + 1)) {
            return mid;
        } else {
            l = mid + 1;
        }
    }
    
    return 0;
};