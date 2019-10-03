/**
 * @param {string} s
 * @return {number}
 */
const operations = {
    '+': (a,b) => a + b,
    '-': (a,b) => a - b,
    '/': (a,b) => Math.floor(a/b),
    '*': (a,b) => a * b
};

const isPriority = ch => ch === '*' || ch === '/';

const toTokens = s => {
    s = s.replace(/ /g, '');
    const res = [];
    let temp = '';
    [...s].forEach(ch => {
        if (operations[ch]) {
            res.push(Number(temp));
            res.push(ch);
            temp = '';
        } else {
            temp += ch;
        }
    })
    res.push(Number(temp));
    return res;
}

var calculate = function(s) {
    
    const tokens = toTokens(s);
    
    const temp = [];

    let i = 0;
    while (i < tokens.length) {
        const token = tokens[i];
        if (isPriority(token)) {
            const left = temp.pop();
            const right = tokens[i + 1];
            const result = operations[token](left, right);
            temp.push(result);
            i += 2;
        } else {
            temp.push(token);
            i++;
        }
    }

    let res = 0;
    i = 0;
    while (i < temp.length) {
        if (operations[temp[i]]) {
            res = operations[temp[i]](res,temp[i + 1]);
            i += 2;
        } else {
            res = temp[i];
            i++;
        }
    }
    return res;
};

module.exports = calculate;