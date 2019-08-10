/**
A binary watch has 4 LEDs on the top which represent the hours (0-11), 
and the 6 LEDs on the bottom represent the minutes (0-59).
 */
var readBinaryWatch = function(num) {
    const res = [];
    for (let h = 0; h < 12; h++) {
        for (let m = 0; m < 60; m++) {
            const bits = hammingWeight(m) + hammingWeight(h);
            if (bits === num) {
                const min = m < 10 ? `0${m}` : `${m}`;
                res.push(`${h}:${min}`)
            }
        }
    }
    return res;
};

var hammingWeight = function(n) {
  
    if (n === 0) return 0;
    
    let result = 0;

    while (n !== 0) {
        if (n & 1) {
            result++;
        }
        n >>>= 1;
    }

    return result;
};