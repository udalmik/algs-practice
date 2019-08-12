var exist = function(board, word) {
    
    if (board.length === 0) return false;
    if (board[0].length === 0) return false;
    if (word.length === 0) return false;

    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            if (existInternal(i, j, board, word)) {
                return true;
            }
        }
    }

    return false;

};

const existInternal = (i, j, board, word) => {
    
    if (word.length === 0) return true;
    if (i < 0 || i >= board.length) return false;
    if (j < 0 || j >= board[0].length) return false;
    
    if (word[0] !== board[i][j]) {
        return false;
    }
    
    board[i][j] = '###';
    const leftLetters = word.substring(1);

    const res = existInternal(i - 1, j, board, leftLetters) 
        || existInternal(i + 1, j, board, leftLetters)
        || existInternal(i, j + 1, board, leftLetters)
        || existInternal(i, j - 1, board, leftLetters);
    
    board[i][j] = word[0];

    return res;
}

module.exports = exist;