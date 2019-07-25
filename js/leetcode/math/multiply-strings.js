
/**
 * Example
 *   Input: num1 = "123", num2 = "456"
 *   Output: "56088"
 */
const multiply = (strNum1, strNum2) => {
    
    const digits1 = [...strNum1].reverse().map(Number);
    const digits2 = [...strNum2].reverse().map(Number);
    
    let multiplier = 0;
    const parts = digits1.map(digit => {
        const val = multiplyToNum(digits2, digit);
        const zeros = new Array(multiplier).fill(0);
        multiplier++;
        return [...zeros, ...val];
    });

    return trimLeadingZeros(parts.reduce((prev, curr) => sumArrays(prev, curr), [])
        .reverse())
        .join("");

};

const sumArrays = (arr1, arr2) => {
    const resultArray = [];
    let p1 = 0;
    let p2 = 0;
    let remainder = false;
    while (p1 < arr1.length || p2 < arr2.length) {
        const v1 = (p1 < arr1.length) ? arr1[p1] : 0;
        const v2 = (p2 < arr2.length) ? arr2[p2] : 0;
        const resValue = v1 + v2 + (remainder ? 1 : 0);
        resultArray.push(resValue % 10);
        remainder = resValue > 9;
        p1++;
        p2++;
    }
    if (remainder) {
        resultArray.push(1);
    }
    return resultArray;
}

const trimLeadingZeros = arr => {
    if (arr.length > 0 && arr[0] === 0) {
        let idx = 0;
        while (arr[idx] === 0 && idx < arr.length - 1) {
            idx++;
        }
        return arr.slice(idx);
    }
    return arr;
}

const multiplyToNum = (reversedNumArr, num) => {
    let res = [];
    let remainder = 0;
    reversedNumArr.forEach(digit => {
        const val = (digit * num) + remainder;
        res.push(val % 10)
        remainder = Math.floor(val / 10);
    });
    if (remainder > 0) {
        res.push(remainder);
    }
    return res;
}

module.exports = { multiply };