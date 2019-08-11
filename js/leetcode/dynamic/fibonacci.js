/**
 * @param {number} N
 * @return {number}
 */
var fib = function(n, memo = {}) {
    if (memo[n]) return memo[n];
    if (n === 0) return 0;
    if (n === 1) return 1;

    const res = fib(n - 1, memo) + fib(n - 2, memo);

    memo[n] = res;

    return res;
};