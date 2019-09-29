/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function(s) {
    
    const mapping = {
        'I': 1,
        'V': 5,
        'X': 10,
        'L': 50,
        'C': 100,
        'D': 500,
        'M': 1000
    }
    
    const subtruction = {
        'IV': 4,
        'IX': 9,
        'XL': 40,
        'XC': 90,
        'CD': 400,
        'CM': 900
    }
    
    let sum = 0;
    
    const romanDigits = [...s];
    
    for (let i = 0; i < romanDigits.length; i++) {
        const curr = romanDigits[i];
        if (i < romanDigits.length - 1) {
            const next = romanDigits[i + 1];
            if (subtruction[curr + next]) {
                sum += subtruction[curr + next];
                i++;
                continue;
            }
        }
        sum += mapping[curr];
    }
    
    return sum;
};