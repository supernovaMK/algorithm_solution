class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet<>();
            for (int i1 = 0; i1 < 9; i1++) {
                if (board[i][i1] != '.') {
                    if (!row.add(board[i][i1]))
                        return false;
                }

            }
              Set<Character> set = new HashSet<>();
            for (int i2 = 0; i2 < 9; i2++) {
                
                if (board[i2][i] != '.')
                    if (!set.add(board[i2][i]))
                        return false;
            }
        }

        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                Set<Character> set = new HashSet<>();
                for(int m=0;m<3;m++){
                    for(int n=0;n<3;n++){
                        if(board[i+m][j+n]!='.')
                            if(!set.add(board[i+m][j+n])) return false;
                    }
                }
            }
        }

        return true;
    }
}