/**
 * @param {number[][]} pairs
 * @return {number}
 */
var findLongestChain = function(pairs) {
   
    if (pairs.length <= 1) return pairs.length;

    pairs = pairs.sort((p1, p2) => p1[0] - p2[0]);

    const lengths = new Array(pairs.length).fill(1);
    let maxLength = 1;

    for (let i = 0; i < pairs.length; i++) {
        const [outerLeft, outerRight] = pairs[i];
        for (let j = 0; j < i; j++) {
            const [innerLeft, innerRight] = pairs[j];
            if (innerRight < outerLeft) {
                const currMax = Math.max(
                    lengths[i],
                    lengths[j] + 1
                );
                lengths[i] = currMax;
                maxLength = Math.max(maxLength, currMax);
            }
        }
    }

    return maxLength;

};