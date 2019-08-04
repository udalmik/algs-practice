/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function (a, b) {

    if (a.length === 0 && b.length) return "0";

    const toNum = ch => ch === '1' ? 1 : 0;

    const aDigits = [...a].map(toNum).reverse();
    const bDigits = [...b].map(toNum).reverse();

    const maxLength = Math.max(aDigits.length, bDigits.length);

    let remainder = 0;
    const res = [];

    for (let i = 0; i < maxLength; i++) {
        const a = i < aDigits.length ? aDigits[i] : 0;
        const b = i < bDigits.length ? bDigits[i] : 0;
        const sum = a + b + remainder;
        if (sum <= 1) {
            res.push(sum);
            remainder = 0;
        } else if (sum === 2) {
            res.push(0);
            remainder = 1;
        } else {
            res.push(1);
            remainder = 1;
        }
    }

    if (remainder > 0) {
        res.push(1);
    }

    return res.reverse().join("");

};