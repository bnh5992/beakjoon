import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int next, cost;

        public Node(int next, int cost) {
            this.next = next;
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

        int student = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());


        ArrayList<Node>[] array = new ArrayList[student + 1];
        for (int i = 0; i < student + 1; i++) {
            array[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            array[Integer.parseInt(st.nextToken())]
                    .add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] result = dijkstra(array, target);
        int[] result2 = comBack(array, target);

        int[] finalResult = new int[result2.length];
        for (int i = 1; i <result2.length ; i++) {
            finalResult[i] = result[i] + result2[i];
        }
        int max = 0;
        for (int i = 1; i < result2.length; i++) {
            max = Math.max(max, finalResult[i]);
        }
        System.out.println(max);
    }

    public static int[] dijkstra(ArrayList<Node>[] array, int target) {
        int[] targetMin = new int[array.length];
        for (int i = 1; i < array.length; i++) {
            int[] minRange = new int[array.length + 1];
            Arrays.fill(minRange, Integer.MAX_VALUE);
            PriorityQueue<Node> q = new PriorityQueue<>();
            q.add(new Node(i, 0));
            minRange[i] = 0;

            while(!q.isEmpty()){
                Node now = q.poll();

                if (now.next == target) {
                    targetMin[i] = minRange[now.next];
			        break;
			    }
                if (minRange[now.next] < now.cost) {
                    continue;
                }
                for (int j = 0; j < array[now.next].size(); j++) {
                    Node nxtNode = array[now.next].get(j);
                    // 만일, 주변 노드까지의 현재 dist값(비용)과 현재 선택된 노드로부터 주변 노드로 가는 비용을 비교하고, 더 작은 값을 선택한다.
                    // 주의점 3 : 중복노드 방지 2 : 만일, 조건문 없이 조건문의 내용을 수행한다면 역시 중복 노드가 발생한다.
                    // 간선에 연결된 노드를 모두 넣어준다면 앞서 언급한 정점의 시간 복잡도 VlogV를 보장할 수 없다.
                    // 마찬가지로 E^2에 수렴할 가능성이 생긴다. 따라서 이 조건 안에서 로직을 진행해야만 한다.
                    if (minRange[nxtNode.next] > now.cost + nxtNode.cost) {
                        minRange[nxtNode.next] = now.cost + nxtNode.cost;
                        // 갱신된 경우에만 큐에 넣는다.
                        q.offer(new Node(nxtNode.next, minRange[nxtNode.next]));
                    }
                }

            }
        }
        return targetMin;

    }

    public static int[] comBack(ArrayList<Node>[] array, int target){
        int[] targetMin = new int[array.length];
        Arrays.fill(targetMin, Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(target, 0));
        targetMin[target] = 0;
        while(!q.isEmpty()){
            Node cur = q.poll();

            if(targetMin[cur.next] > cur.cost) continue;

            for (int i = 0; i < array[cur.next].size(); i++) {
                Node nextNode = array[cur.next].get(i);

                if(targetMin[nextNode.next] > cur.cost + nextNode.cost){
                    targetMin[nextNode.next] = cur.cost + nextNode.cost;

                    q.offer(new Node(nextNode.next,targetMin[nextNode.next]));
                }
            }
        }
        return targetMin;
    }
}