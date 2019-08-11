/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    
    let buy = prices[0];
    let sell = prices[1];
    let min = Math.min(buy, sell);
    let profit = sell - buy > 0 ? sell - buy : 0;
    
    for (let i = 2; i < prices.length; i++) {
        const price = prices[i];
        if (price - min > profit) {
            profit = price - min;
        }
        min = Math.min(min, price);
    }
    
    return profit;
};