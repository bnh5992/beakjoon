import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        PriorityQueue<Integer> rq = new PriorityQueue<>(Collections.reverseOrder());
        q.add(Integer.valueOf(br.readLine()));
        sb.append(q.peek()).append("\n");
        for (int i = 0; i < n-1; i++) {
            int now = Integer.parseInt(br.readLine());
            if(q.size() == rq.size()+2){
                if(now < q.peek()){
                    rq.add(now);
                }
                else{
                    q.add(now);
                    rq.add(q.poll());
                }
            }
            else{
                if(now < q.peek()){
                    rq.add(now);
                    q.add(rq.poll());
                    sb.append(q.peek()).append("\n");
                    continue;
                }
                else{
                    q.add(now);
                }
            }

            sb.append(q.peek()).append("\n");
        }
        System.out.println(sb);
    }
}