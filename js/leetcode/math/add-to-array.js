/**
 * @param {number[]} A
 * @param {number} K
 * @return {number[]}
 */
var addToArrayForm = function(a, k) {
    const kReversed = toReversedArray(k);
    return sumReversedArrays(a.reverse(), kReversed)
        .reverse();
};

const sumReversedArrays = (a, b) => {
    
    if (a.length === 0) return b;
    if (b.length === 0) return a;

    const maxLength = Math.max(a.length, b.length);

    let remainder = 0;

    const res = [];
    
    for (let i = 0; i < maxLength; i++) {
        const aNum = a.length > i ? a[i] : 0;
        const bNum = b.length > i ? b[i] : 0;
        const sum = aNum + bNum + remainder;
        res.push(sum % 10);
        remainder = Math.floor(sum / 10);
    }

    if (remainder > 0) {
        res.push(remainder);
    }

    return res;

}

const toReversedArray = num => {
    const res = [];
    while (num > 0) {
        res.push(num % 10);
        num = Math.floor(num / 10);
    }
    return res;
}