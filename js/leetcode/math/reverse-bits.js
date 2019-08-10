/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    if (n === 0 || n === -1) return n;
    
    let leftShift = 31;
    let rightShift = 0;

    let result = 0;
    
    while (leftShift > rightShift) {
        
        const leftMask = 1 << leftShift;
        const rightMask = 1 << rightShift;
        const leftBit = n & leftMask;
        const rightBit = n & rightMask;
        
        if (rightBit) {
            result |= leftMask;
        }

        if (leftBit) {
            result |= rightMask;
        }

        leftShift--;
        rightShift++;
    }
    
    return result >>> 0;
};