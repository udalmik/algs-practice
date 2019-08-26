/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function (amount, coins) {

    const dp = new Array(amount + 1).fill(0);

    dp[0] = 1;

    for (let j = 0; j < coins.length; j++) {
        for (let i = 1; i <= amount; i++) {
            if (i >= coins[j]) {
                dp[i] += (dp[i - coins[j]]);
            }
        }
    }

    return dp[amount];

};

