/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    const totalCost = new Array(cost.length);
    totalCost[0] = cost[0];
    totalCost[1] = cost[1];

    for (let i = 2; i < cost.length; i++) {
        totalCost[i] = Math.min(totalCost[i - 1] + cost[i], totalCost[i - 2] + cost[i]);
    }

    return Math.min(totalCost[cost.length - 1], totalCost[cost.length - 2]);
};