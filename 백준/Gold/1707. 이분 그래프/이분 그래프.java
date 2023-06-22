import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());


        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dot = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] array = new ArrayList[dot + 1];
            boolean[] visited = new boolean[dot + 1];
            int[] color = new int[dot + 1];
            for (int j = 0; j < dot + 1; j++) {
                array[j] = new ArrayList<>();
            }

            int link = Integer.parseInt(st.nextToken());
            for (int j = 0; j < link; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                array[start].add(end);
                array[end].add(start);
            }

            boolean result = true;
            for (int j = 1; j < dot + 1; j++) {
                if (!visited[j]) {
                    result = bfs(array, j, visited, color);
                    if (!result) {
                        System.out.println("NO");
                        break;
                    }
                }
            }
            if (result) {
                System.out.println("YES");
            }


        }
    }

    public static boolean bfs(ArrayList<Integer>[] array, int start, boolean[] visited, int[] color) {


        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 1;
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < array[cur].size(); i++) {
                int next = array[cur].get(i);
                if (color[next] == color[cur]) {
                    return false;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                    if (color[cur] == 1) {
                        color[next] = 2;
                    } else if (color[cur] == 2) {
                        color[next] = 1;
                    }
                }
            }
        }


        return true;
    }
}