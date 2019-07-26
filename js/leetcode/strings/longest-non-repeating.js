const lengthOfLongestSubstring = s => {
    if (s.length === 0) return 0;
    if (s.length === 1) return 1;
    const set = new Set();
    let max = 1;
    const chars = [...s];
    let start = 0;
    let end = 1;
    set.add(chars[start]);
    while (end < chars.length) {
        if (start === end) {
            set.clear();
            set.add(chars[start]);
            end++;
        } else if (!set.has(chars[end])) {
            set.add(chars[end]);
            max = Math.max(max, set.size);
            end++;
        } else {
            set.delete(chars[start]);
            start++;
        }
    }
    return max;
}