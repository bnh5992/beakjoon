class Solution {
    public int solution(String[][] board, int h, int w) {
        int count = 0;
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};
        
        for(int i = 0; i< dr.length; i++){
            int nextR = h + dr[i];
            int nextC = w + dc[i];
            if(nextR < 0 || nextC < 0 || nextR >= board.length || nextC >= board.length) continue;
            
            if(board[h][w].equals(board[nextR][nextC])) count++;
        }
        return count;
    }
}