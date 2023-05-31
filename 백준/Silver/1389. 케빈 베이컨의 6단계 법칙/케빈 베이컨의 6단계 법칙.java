import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos{
        int start, dist;
        public Pos(int start, int dist){
            this.start = start;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int user = Integer.parseInt(st.nextToken());
        int relation = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] array = new ArrayList[user + 1];
        for (int i = 0; i < user + 1; i++) {
            array[i] = new ArrayList<>();
        }
        for (int i = 0; i < relation; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[a].add(b);
            array[b].add(a);
        }

        int min = Integer.MAX_VALUE;
        int people = 0;
        for (int i = 1; i < user + 1; i++) {
            boolean[] visited = new boolean[user + 1];
            visited[i] = true;
            int result = bfs(i, visited, array);

            if(min > result){
                min = result;
                people = i;
            }
        }
        System.out.println(people);
    }

    public static int bfs(int i, boolean[] visited, ArrayList<Integer>[] array){
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(i,0));
        int sum = 0;
        while(!q.isEmpty()){
            Pos now = q.poll();
            for (int j = 0; j < array[now.start].size(); j++) {
                if(visited[array[now.start].get(j)]) continue;
                visited[array[now.start].get(j)] = true;
                sum += now.dist+1;
                q.add(new Pos(array[now.start].get(j), now.dist+1));
            }
        }
        return sum;
    }
}