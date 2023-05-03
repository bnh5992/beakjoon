import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> rq = new PriorityQueue<>(Collections.reverseOrder());
        rq.add(Integer.valueOf(br.readLine()));
        sb.append(rq.peek()).append("\n");

        for (int i = 0; i < n-1; i++) {
            if(i%2 != 0){
                rq.add(Integer.valueOf(br.readLine()));
                if(q.peek()<rq.peek()){
                    q.add(rq.poll());
                    rq.add(q.poll());
                }
            }
            else{
                q.add(Integer.valueOf(br.readLine()));
                if(q.peek()<rq.peek()){
                    q.add(rq.poll());
                    rq.add(q.poll());
                }
            }
            sb.append(rq.peek()).append("\n");
        }
        System.out.println(sb);

    }
}