class Solution {
    public boolean isValidSudoku(char[][] board) {
        // check rows
        for (int i = 0; i < 9; i++){
            boolean[] chs = new boolean[9];
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.'){
                    continue;
                }
                else if (chs[board[i][j] - '1']){
                    return false;
                }
                else{
                    chs[board[i][j] - '1'] = true;
                }
            }
        }
        // check columns
        for (int j = 0; j < 9; j++){
            boolean[] chs = new boolean[9];
            for (int i = 0; i < 9; i++){
                if (board[i][j] == '.'){
                    continue;
                }
                else if (chs[board[i][j] - '1']){
                    return false;
                }
                else{
                    chs[board[i][j] - '1'] = true;
                }
            }
        }
        // check sub-boxes
        for (int m = 0; m < 3; m++){
            for (int n = 0; n < 3; n++){
                boolean[] chs = new boolean[9];
                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){
                        if (board[3 * m + i][3 * n + j] == '.'){
                            continue;
                        }
                        if (chs[board[3 * m + i][3 * n + j] - '1']){
                            return false;
                        }
                        else{
                            chs[board[3 * m + i][3 * n + j] - '1'] = true;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
