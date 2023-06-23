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
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[V + 1];
        ArrayList<Node>[] array = new ArrayList[V + 1];

        for (int i = 0; i < V+1; i++) {
            array[i] = new ArrayList<>();
        }

        int start = Integer.parseInt(br.readLine());


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            array[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }
        int[] result = dijkstra(array, V, start, visited);
        for (int i = 1; i < result.length; i++) {
            if(result[i] == Integer.MAX_VALUE){
                System.out.println("INF");
                continue;
            }
            System.out.println(result[i]);
        }
    }

    public static int[] dijkstra(ArrayList<Node>[] array, int v, int start, boolean[] visited){
        int[] dist = new int[v+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        while(!q.isEmpty()){
            int cur = q.poll().index;

            if(visited[cur]) continue;
            visited[cur] = true;

            for (Node next: array[cur]) {
                if(dist[next.index] > dist[cur] + next.cost){
                    dist[next.index] = dist[cur] + next.cost;
                    q.add(new Node(next.index, dist[next.index]));
                }
            }
        }
        return dist;
    }
}