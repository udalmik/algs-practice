class MinStack {
    _data = [];
    _min = [];
    push(x) {
        this._data.push(x);
        if (this._min.length === 0) {
            this._min.push(x);
        } else {
            this._min.push(Math.min(this._min[this._min.length - 1], x));
        }
    }
    top() {
        return this._data[this._data.length - 1];
    }
    pop() {
        this._min.pop();
        return this._data.pop();
    }
    getMin() {
        return this._min[this._min.length - 1];
    }
}

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = new MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */