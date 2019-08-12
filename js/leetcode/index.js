

const maxArea = require('./two-pointers/water-container');
const generateParenthesis = require('./backtracking/generate-parenthesis');

const exist = require('./dynamic/find-word');

console.log(exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"));

console.log(exist(
    [
        ["b","a","a","b","a","b"],
        ["a","b","a","a","a","a"],
        ["a","b","a","a","a","b"],
        ["a","b","a","b","b","a"],
        ["a","a","b","b","a","b"],
        ["a","a","b","b","b","a"],
        ["a","a","b","a","a","b"]], "aabbbbabbaababaaaabababbaaba"));

console.log(exist([["a"]], "ab"))
