/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    
    const solutions = [];
    const tried = new Set();
    const helper = (currentEls, currentSum, values) => {
        const key = String(currentEls);
        if (tried.has(key)) {
            return;
        } else {
            tried.add(key);
        }
        if (currentSum === target) {
            solutions.push([...currentEls]);
            return;
        } else if (currentSum > target) {
            return;
        }
        const last = currentEls.length === 0 ? 0 : currentEls[currentEls.length - 1];
        for (let i = 0; i < values.length; i++) {
            const value = values[i];
            if (value >= last) {
                currentEls.push(value);
                helper(currentEls, currentSum + value, values);
                currentEls.pop();    
            }
        }       
    };
    
    helper([], 0, candidates);
    
    return solutions;
};

module.exports = combinationSum;