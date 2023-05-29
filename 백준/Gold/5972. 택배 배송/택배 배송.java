import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int index, cost;
        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] graph = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w,cost));
            graph[w].add(new Node(v,cost));
        }
        int[] result = dijkstra(n, 1, graph);

        System.out.println(result[n]);
    }

    public static int[] dijkstra(int n, int start, ArrayList<Node>[] graph){
        boolean[] visited = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));

        while(!q.isEmpty()){
            int now = q.poll().index;

            if(visited[now]) continue;
            visited[now] = true;

            for(Node next : graph[now]) {
                if(dist[next.index] > dist[now]+ next.cost) {
                    dist[next.index] = dist[now] + next.cost;

                    q.offer(new Node(next.index, dist[next.index]));
                }
            }
        }
        return dist;
    }
}