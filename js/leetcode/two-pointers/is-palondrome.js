/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {

    const chars = [...s.toLowerCase()].filter(isLetter);

    if (chars.length === 0) return true;
    
    let start = 0;
    let end = chars.length - 1;
    
    while (start < end) {
        while (!isLetter(chars[start]) && start < chars.length) {
            start++;
        }
        while (!isLetter(chars[end]) && end >= 0) {
            end--;
        }
        if (start < end && start < chars.length && end > 0 && chars[start] !== chars[end]) {
            return false;
        }
        start++;
        end--;
    }

    return true;
};

const isLetter = s => !!s.match(/^[a-z0-9]+$/i)