/**
 * @param {number} x
 * @return {boolean}
 * 
 * without conversion to string
 */
const isPalindrome = num => {
    if (num < 0) return false;
    if (num < 10) return true;
    const digits = [];
    while (num > 0) {
        digits.push(num % 10);
        num = Math.floor(num / 10);
    }
    let left = 0;
    let right = digits.length - 1;
    while (left < right) {
        if (digits[left] !== digits[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
};