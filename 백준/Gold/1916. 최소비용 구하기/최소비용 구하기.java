import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node>{
        int index;
        int cost;
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
        int city = Integer.parseInt(br.readLine());
        int bus = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[city + 1];
        ArrayList<Node>[] array = new ArrayList[city + 1];

        for (int i = 0; i < city+1; i++) {
            array[i] = new ArrayList<>();
        }


        StringTokenizer st;

        for (int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine());
            array[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] result = dijkstra(array, visited, start, city);
        System.out.println(result[end]);
    }

    static int[] dijkstra(ArrayList<Node>[] array, boolean[] visited, int start, int city){
        int[] dist = new int[city+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<>();
        dist[start] = 0;
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