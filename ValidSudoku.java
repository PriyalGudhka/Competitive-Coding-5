// Time Complexity : O(1) even though we have used for loops to iterate over row, column & block the overall time complexity is contant as we only iterate 81 times in total
// Space Complexity: O(1) we have used boolean array of fixed size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: For row & column, used boolean[] of size 9. Checked if that index is already marked as true which means we already have that number so simply return false. For block, used few calculations to find the row & column to iterate and checked if that index is already marked as true which means we already have that number so simply return false.

class Solution {
    public boolean isValidSudoku(char[][] board) {

        if(board == null || board.length != 9 || board[0].length != 9){
            return false;
        }

        //Row
        for(int i = 0; i < 9; i++){
            boolean[] b = new boolean[9];
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(b[(int)board[i][j] - '1']){
                        return false;
                    }
                    b[(int)board[i][j] - '1'] = true;
                }
            }
        }

        //Column
        for(int j = 0; j < 9; j++){
            boolean[] b = new boolean[9];
            for(int i = 0; i < 9; i++){
                if(board[i][j] != '.'){
                    if(b[(int)board[i][j] - '1']){
                        return false;
                    }
                    b[(int)board[i][j] - '1'] = true;
                }
            }
        }

        //Board
        for(int block = 0; block < 9; block++){
            boolean[] b = new boolean[9];
            for(int i = block/3*3; i < block/3*3+3; i++){
                for(int j = block%3*3; j < block%3*3+3; j++){
                    if(board[i][j] != '.'){
                        if(b[(int)board[i][j] - '1']){
                            return false;
                        }
                        b[(int)board[i][j] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }
}