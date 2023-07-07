import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class use implements Comparable<use> {
        int start, time;

        public use(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(use o) {
            return this.start > o.start ? 1 : -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int lockTime = Integer.parseInt(st.nextToken());
        PriorityQueue<use> q = new PriorityQueue<>();
        PriorityQueue<Integer> tq = new PriorityQueue<>();
        for (int i = 0; i < people; i++) {
            st = new StringTokenizer(br.readLine());
            q.add(new use(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }


        int count = 0;
        while (!q.isEmpty()) {
            boolean using = false;
            use cur = q.poll();
            if (tq.isEmpty()) {
                tq.add(cur.start + cur.time);
                continue;
            }
            while (!tq.isEmpty()) {
                if (tq.peek() > cur.start) {
                    tq.add(cur.start + cur.time);
                    break;
                }
                if (tq.peek() + lockTime < cur.start) {
                    tq.poll();
                }
                else{
                    using = true;
                    break;
                }
            }
            if(using){
                tq.poll();
                tq.add(cur.start + cur.time);
                count++;
            }

        }


        System.out.println(count);

    }
}