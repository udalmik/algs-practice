/**
 Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
*/
const intToRoman = num => {
    const roman = exception(num);
    if (roman) return roman;

    const symbols = [
        ["I", 1],
        ["IV", 4],
        ["V", 5],
        ["IX", 9],
        ["X", 10],
        ["XL", 40],
        ["L", 50],
        ["XC", 90],
        ["C", 100],
        ["CD", 400],
        ["D", 500],
        ["CM", 900],
        ["M", 1000]
    ].reverse();
    return toRoman("", num, symbols, 0);
}

const exception = num => {
    if (num === 4) return "IV";
    if (num === 9) return "IX";
    if (num === 40) return "XL"
    if (num === 90) return "XC";
    if (num === 400) return "CD";
    if (num === 900) return "CM";
    return undefined;
}

const toRoman = (current, num, symbols, idx) => {
    if (idx === symbols.length) {
        return current;
    }
    const [s, v] = symbols[idx];
    let temp;
    if (num >= v) {
        const multiplier = Math.floor(num / v);
        num = num % v;
        current += s.repeat(multiplier);
    }
    return toRoman(current, num, symbols, idx + 1);
}

module.exports = intToRoman;