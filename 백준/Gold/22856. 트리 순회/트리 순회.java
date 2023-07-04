import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] array = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            array[start].add(right);
            array[start].add(left);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int count = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(array[cur].get(1) == -1) {
                break;
            }
            q.add(array[cur].get(1));
            count++;
        }
        System.out.println(2*(n-1)-count);




    }
}