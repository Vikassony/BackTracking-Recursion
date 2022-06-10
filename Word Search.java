Question Link : https://leetcode.com/problems/word-search/

/*Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
*/
class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if((board[i][j]==word.charAt(0)) && dfs(board,i,j,0,word))
                    return true;
            }
        }
        return false;
    }
    boolean dfs(char board[][], int i, int j, int count , String word){
        if(word.length()==count)
            return true;
        if(i==-1 || i>=board.length || j==-1 || j>=board[0].length || board[i][j]!=word.charAt(count))
            return false;
        char temp = board[i][j];
        board[i][j] = '*';
        boolean found = dfs(board,i+1,j,count+1,word)||
                        dfs(board,i-1,j,count+1,word)||
                        dfs(board,i,j+1,count+1,word)||
                        dfs(board,i,j-1,count+1,word);
        board[i][j] = temp;
            return found;
    }
}
 
