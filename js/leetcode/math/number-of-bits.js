/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
  
    if (n === 0) return 0;
    
    let result = 0;

    while (n !== 0) {
        if (n & 1) {
            result++;
        }
        n >>>= 1;
    }

    return result;
};