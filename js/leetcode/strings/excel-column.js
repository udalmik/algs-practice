/**
 * @param {string} s
 * @return {number}
 * https://leetcode.com/problems/excel-sheet-column-number/
 */

const baseCharCode = 'A'.charCodeAt(0) - 1;

const charToNumber = char => char.charCodeAt(0) - baseCharCode;

 var titleToNumber = function(s) {
    if (!s || s.length === 0) return 0;
    return s.split("").reduce((acc, letter, idx) => {
        const power = s.length - idx - 1;
        return acc + Math.pow(26, power) * charToNumber(letter);
    }, 0);
};

