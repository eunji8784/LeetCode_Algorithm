class Solution {
    public void solveSudoku(char[][] board) {
        char[][] row = new char[10][10];
        char[][] col = new char[10][10];
        char[][] box = new char[10][10];
        char[][] backup = new char[9][9];
        
        for (int i = 0; i < 9; i++) {
            System.arraycopy(board[i], 0, backup[i], 0, 9);
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (backup[i][j] != '.') {
                    int num = backup[i][j] - '0';
                    col[i][num] = '1';
                    row[j][num] = '1';
                    box[3 * (i / 3) + j / 3][num] = '1';
                }
            }
        }
        
        backtracking(0, 0, backup, row, col, box, board);
    }
    
    private static void backtracking(int i, int j, char[][] backup, char[][] row, char[][] col, char[][] box, char[][] board) {
        if (j > 8) {
            if (i == 8) {
                for (int x = 0; x < 9; x++) {
                    System.arraycopy(backup[x], 0, board[x], 0, 9);
                }
                return;
            }
            i++;
            j = 0;
        }
        
        if (backup[i][j] == '.') {
            int boxNum = 3 * (i / 3) + j / 3;
            for (int num = 1; num <= 9; num++) {
                if(col[i][num] != '1' && row[j][num] != '1' && box[boxNum][num] != '1') {
                    setValue('1', num, i, j, backup, row, col, box);
                    backtracking(i, j + 1, backup, row, col, box, board);
                    setValue('.', num, i, j, backup, row, col, box);
                }
            }
        } else {
            backtracking(i, j + 1, backup, row, col, box, board);
        }
    }
    
    private static void setValue(char value, int num, int i, int j, char[][] backup, char[][] row, char[][] col, char[][] box) {
        if (value == '1') {
            backup[i][j] = (char)(num+'0');
        } else if (value == '.') {
            backup[i][j] = value;
        }
        col[i][num] = value;
        row[j][num] = value;
        box[3 * (i / 3) + j / 3][num] = value;
    }
    
}