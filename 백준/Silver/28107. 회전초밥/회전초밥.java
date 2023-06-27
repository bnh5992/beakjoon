import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int customer = Integer.parseInt(st.nextToken());
        int sushi = Integer.parseInt(st.nextToken());

        int[] result = new int[customer];
        ArrayList<Integer>[] array = new ArrayList[2000001];

        for (int i = 0; i < 2000001; i++) {
            array[i] = new ArrayList<>();
        }
        for (int i = 0; i < customer; i++) {
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                array[next].add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        while (st.hasMoreTokens()) {
            q.add(Integer.valueOf(st.nextToken()));
        }

        while(!q.isEmpty()){
            int now = q.poll();
            if(array[now].size() > 0){
                result[array[now].get(0)]++;
                array[now].remove(0);
            }
        }



        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customer; i++) {
            sb.append(result[i] + " ");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sb));
        bw.flush();
    }
}