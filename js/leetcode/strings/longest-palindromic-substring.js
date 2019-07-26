
const longestPalindrome = s => {
    if (!s || s.length <= 1) return s;
    let res = "";
    [...s].forEach((ch, idx, arr) => {
        let maxLengthPalindrome = maxPalindrome(s, idx, idx);
        if (res.length < maxLengthPalindrome.length) {
            res = maxLengthPalindrome;
        }
        maxLengthPalindrome = maxPalindrome(s, idx, idx + 1);
        if (res.length < maxLengthPalindrome.length) {
            res = maxLengthPalindrome;
        }
    });
    return res;
};

const maxPalindrome = (s, start, end) => {
    while (end < s.length && start >= 0 && s[start] === s[end]) {
        start--;
        end++;
    }
    return s.substring(start + 1, end);
}

module.exports = longestPalindrome;