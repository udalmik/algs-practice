/**
 * @param {string[]} words
 * @return {number}
 */
var longestStrChain = function(words) {
    words = words.sort((a, b) => a.length - b.length);
    const chains = new Map();
    let currMax = 1;
    words.forEach(w => {
        if (w.length === 1) {
            chains.set(w, 1);
        } else {
            const prevChain = getMaxSubChain(w, chains);
            const currChain = chains.get(w) || 1;
            const max = Math.max(prevChain + 1, currChain);
            if (max > currMax) {
                currMax = max;
            }
            chains.set(w, max);             
        }
    })

    return currMax;

};

const getMaxSubChain = (w, chains) => {
    let res = 0;
    for (let i = 0; i < w.length; i++) {
        const candidate = w.substring(0, i) + w.substring(i + 1, w.length);
        const candidateLength = chains.get(candidate) || 0;
        if (candidateLength > res) {
            res = candidateLength;
        }
    }
    return res;
}