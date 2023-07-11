import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class finalScore implements Comparable<finalScore>{
        int start, timeToStudy;
        public finalScore(int start, int timeToStudy){
            this.start = start;
            this.timeToStudy = timeToStudy;
        }

        @Override
        public int compareTo(finalScore o) {
            return this.timeToStudy >= o.timeToStudy ? -1 : 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = 24 * Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] score = new int[n];
        int[] timeToStudy = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            timeToStudy[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<finalScore> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.add(new finalScore(score[i], timeToStudy[i]));
        }

        while(true){
            finalScore now = q.poll();
            if(now.timeToStudy == 0) {
                q.add(now);
                break;
            }
            int fScore = 100 - now.start;
            int remain = fScore/now.timeToStudy;
            if(time < remain){
                now.start += time * now.timeToStudy;
                q.add(now);
                break;
            }
            else{
                now.start += fScore - fScore % now.timeToStudy;
            }
            time -= remain;
            now.timeToStudy = 100 - now.start;
            q.add(now);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += q.poll().start;
        }
        System.out.println(result);
    }
}