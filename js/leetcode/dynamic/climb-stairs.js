/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n, memo = {}) {
    
    if (memo[n]) {
        return memo[n];
    }

    if (n === 1) return 1;
    if (n === 2) return 2;

    const res = climbStairs(n - 2, memo) + climbStairs(n - 1, memo);
    
    memo[n] = res;
    
    return res;

};
