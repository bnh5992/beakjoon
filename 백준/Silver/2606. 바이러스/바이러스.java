import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int start, end;

        public Pos(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computers = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());


        ArrayList<Integer>[] array = new ArrayList[computers + 1];

        boolean[] visited = new boolean[computers + 1];
        for (int i = 0; i < computers + 1; i++) {
            array[i] = new ArrayList<>();
        }
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            array[start].add(end);
            array[end].add(start);

        }
        System.out.println(bfs(1,visited,array));



    }

    public static int bfs(int start, boolean[] visited, ArrayList<Integer>[] array){
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < array[cur].size(); i++) {
                if(visited[array[cur].get(i)]) continue;
                visited[array[cur].get(i)] = true;
                q.add(array[cur].get(i));
                count++;
            }
        }
        return count-1;
    }
}