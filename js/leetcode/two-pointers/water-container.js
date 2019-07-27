

/**
 * @param {number[]} height
 * @return {number}
 */
const maxAreaBruteForce = heights => {
    let result = 0;
    heights.forEach((h1, i) => {
        heights.forEach((h2, j) => {
            if (i < j && h1 > 0 && h2 > 0) {
                result = Math.max(result, (j - i) * Math.min(h1, h2));
            } 
        });
    });
    return result;
};

const maxArea = heights => {
    let result = 0;
    let left = 0;
    let right = heights.length - 1;

    while (right > left) {
        result = Math.max(result, (right - left) * Math.min(heights[right], heights[left]));
        if (heights[left] < heights[right]) {
            left++;
        } else {
            right--;
        }
    }

    return result;
};



module.exports = maxArea;