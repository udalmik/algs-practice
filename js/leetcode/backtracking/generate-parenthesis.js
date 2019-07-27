

const generateParenthesis = n => {
    return _generateParenthesis([""], n, n);
};

const _generateParenthesis = (current, left, right) => {
    if (left <= 0 && right <= 0) {
        return current;
    }
    let result = [];
    if (left > 0) {
        // append (
        result = _generateParenthesis(current.map(curr => curr + "("), left - 1, right);
    } 
    if (right > left) {
        result = [
            ...result, 
            ..._generateParenthesis(current.map(c => c + ")"), left, right - 1)
        ]
    }
    return result;
}

module.exports = generateParenthesis;