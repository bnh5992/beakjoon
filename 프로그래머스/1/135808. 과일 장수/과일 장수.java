import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int result = 0;
        for(int i = score.length-1; i >= 0; i = i-m){
            if(i-m+1 < 0) break;
            result = result + score[i-m+1]*m;
        }
        return result;
        
    }
}