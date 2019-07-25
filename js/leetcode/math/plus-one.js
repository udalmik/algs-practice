
const plusOne = digits => {
    if (digits[0] === 0) {
        return [1];
    }
    let idx = digits.length - 1;
    let remainder = 1
    while (idx >= 0 && remainder) {
        const value = digits[idx] + 1;
        if (value < 10) {
            digits[idx] = value;
            remainder = false;
            break;
        } else {
            digits[idx] = 0;
            remainder = true;
        }
        idx--;
    }
    return remainder ? [1, ...digits] : digits;
}

module.exports = plusOne;