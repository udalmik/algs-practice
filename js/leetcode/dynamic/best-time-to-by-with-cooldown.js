


/**
 * @param {number[]} prices
 * @return {number}
 */
const maxProfit = prices => {
  
    if (!prices || prices.length <= 1) return 0;

    const sell = new Array(prices.length).fill(0);
    const cooldown = new Array(prices.length).fill(0);

    sell[1] = prices[1] - prices[0];

    for (let i = 2; i < prices.length; i++) {
        cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        sell[i] = prices[i] - prices[i - 1] + Math.max(sell[i - 1], cooldown[i - 2]);
    }
    
    return Math.max(sell[prices.length - 1], cooldown[prices.length - 1]);
};