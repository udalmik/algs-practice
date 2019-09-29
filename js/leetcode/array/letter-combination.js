/**
 * @param {string} digits
 * @return {string[]}
 */


var letterCombinations = function(digits) {
    const dimensions = [...digits].map(d => letters[d]);
    const enhanceResult = (current, dimension) => {
        if (current.length === 0) return dimension;
        const enhanced = current
            .map(c => dimension.map(d => c + d))
            .reduce((prev, curr) => ([...prev, ...curr]), []);
        return enhanced;
    }
    return dimensions.reduce((current, next) => enhanceResult(current, next), []);
};

const letters = {
    '2': ['a', 'b', 'c'],
    '3': ['d', 'e', 'f'],
    '4': ['g', 'h', 'i'],
    '5': ['j', 'k', 'l'],
    '6': ['m', 'n', 'o'],
    '7': ['p', 'q', 'r', 's'],
    '8': ['t', 'u', 'v'],
    '9': ['w', 'x', 'y', 'z']
};