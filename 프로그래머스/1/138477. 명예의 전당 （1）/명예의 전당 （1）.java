import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int min = 9999;
        for(int i = 0; i < score.length; i++){
            q.add(score[i]);
            pq.add(score[i]);
            if(q.size() > k){
                q.poll();
                pq.poll();
            }
            if(pq.peek() > min){
                min = pq.peek();
                answer[i] = min;
                continue;
            }
            min = Math.min(pq.peek(), min);
            answer[i] = min;
        }
        
        return answer;
    }
}