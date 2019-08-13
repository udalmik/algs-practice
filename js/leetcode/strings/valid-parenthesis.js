/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    if (!s || s.length === 0) return true;

    const brackets = new Map([['}', '{'], [')', '('], [']', '[']]);
    const stack = [];

    for (const ch of s) {
        if (!brackets.has(ch)) {
            stack.push(ch);
            continue;
        }
        if (stack.length === 0) {
            return false;
        }
        const last = stack.pop();
        if (last !== brackets.get(ch)) {
            return false;
        }
    }

    return stack.length === 0;

};