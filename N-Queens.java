Question Link : https://leetcode.com/problems/n-queens/
/*

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

*/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char board[][] = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        boolean cols[] = new boolean[n];
        boolean nDiag[] = new boolean[2 * n - 1];
        boolean rDiag[] = new boolean[2 * n - 1];
        solve(board,0,cols,nDiag,rDiag,res);
        return res;
    }
    public void solve(char board[][], int row, boolean cols[], boolean nDiag[], boolean rDiag[],List<List<String>> res){
        if(row == board.length){
            ArrayList<String> al = new ArrayList<>();
            for(int i=0;i<board.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<board[0].length;j++){
                    sb.append(Character.toString(board[i][j]));
                }
                al.add(sb.toString());
            }
            res.add(al);
            return;
        }
        for(int col = 0; col<board[0].length;col++){
            if(cols[col] == false && nDiag[row + col] == false && rDiag[row - col + board.length - 1] == false){
                board[row][col] = 'Q';
                cols[col] = true;
                nDiag[row + col] = true;
                rDiag[row - col + board.length - 1] = true;
                solve(board,row+1, cols,nDiag,rDiag,res);
                board[row][col] = '.';
                cols[col] = false;
                nDiag[row + col] = false;
                rDiag[row - col + board.length - 1] = false;
            }
        }
    }
}
