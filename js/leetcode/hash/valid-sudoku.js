/**
 * @param {character[][]} board
 * @return {boolean}
 */
var isValidSudoku = function(board) {
    
    const rows = sudokuHashMap();
    const columns = sudokuHashMap();
    const boxes = sudokuHashMap();
        
    for (let row = 0; row < 9; row++) {
        for (let col = 0; col < 9; col++) {
            const val = board[row][col];
            if (val === '.') {
                continue;
            }
            if (!validate(row, rows, val)
                || !validate(col, columns, val)
                || !validate(getBoxNum(row, col), boxes, val)) {
                return false;
            }
        }
    }
    return true;
};

const validate = (idx, map, candidate) => {
    const set = map.get(idx);
    if (set.has(candidate)) {
        return false;
    }
    set.add(candidate);
    return true;
}

const sudokuHashMap = () => {
    const res = new Map();
    for (let i = 0; i < 9; i++) {
        res.set(i, new Set());
    }
    return res;
}

const getBoxNum = (i, j) => {
    return 3 * (Math.floor(i/3)) + Math.floor(j/3);
}