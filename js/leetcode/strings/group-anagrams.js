/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    
    const cache = new Map();

    strs.forEach(s => {
        const key = [...s].sort().join("");
        const arr = cache.get(key) || [];
        arr.push(s);
        cache.set(key, arr);
    });

    return [...cache.values()];
};