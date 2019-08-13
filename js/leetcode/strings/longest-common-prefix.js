/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
    if (!strs || strs.length === 0) return "";
    strs = strs.sort((a,b) => a.length - b.length);
    let res = '';
    const first = strs[0];
    for (let i = 0; i < first.length; i++) {
        const ch = strs[0][i];
        let common = true;
        for (let j = 1; j < strs.length; j++) {
            if (strs[j][i] !== ch) {
                common = false;
                break;
            }
        }
        if (common) {
            res = res + ch;
        } else {
            break;
        }
    }
    return res;
};