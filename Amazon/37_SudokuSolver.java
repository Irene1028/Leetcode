class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
        return;
    }
    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        //System.out.println(board[i][j]);
                        if (isValid(board, i, j, k)) {
                            board[i][j] = k;
                            //System.out.println(board[i][j]);
                            if (solve(board)) {   
                                return true;
                            } 
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[row][k] != '.' && board[row][k] == c) return false;
            if (board[k][col] != '.' && board[k][col] == c) return false;
            int blocki = (row / 3) * 3;
            int blockj = (col / 3) * 3;
            if (board[blocki + k/3][blockj  + k%3] != '.' && board[blocki + k/3][blockj  + k%3] == c) return false;
        }
        return true;
    }
}
