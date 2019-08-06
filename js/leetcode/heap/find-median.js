/** 
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = new MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */
/**
 * initialize your data structure here.
 * https://leetcode.com/problems/find-median-from-data-stream/solution/
 */
var MedianFinder = function() {
    this.median = 0;
    this.sortedNums = [];
};

/** 
 * @param {number} num
 * @return {void}
 */
MedianFinder.prototype.addNum = function(num) {
    insertToSorted(this.sortedNums, num);
    if (this.sortedNums.length === 1) {
        this.median = num;
    } else if (this.sortedNums.length % 2 === 1) {
        this.median = this.sortedNums[(this.sortedNums.length - 1) / 2]
    } else {
        const left = this.sortedNums[this.sortedNums.length / 2];
        const right = this.sortedNums[(this.sortedNums.length / 2) - 1];
        this.median = (left + right) / 2;
    }
};

const insertToSorted = (arr, num) => {
    let pos = arr.length;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] > num) {
            pos = i;
            break;
        }
    }
    arr.splice(pos, 0, num);
}

/**
 * @return {number}
 */
MedianFinder.prototype.findMedian = function() {
    return this.median;
};

/** 
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = new MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */