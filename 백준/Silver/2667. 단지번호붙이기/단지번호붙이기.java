import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static class Pos {
        int r, c, dist;

        public Pos(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int[][] world = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String col = br.readLine();
            for (int j = 0; j < col.length(); j++) {
                world[i][j] = Integer.parseInt(String.valueOf(col.charAt(j)));
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (world[i][j] == 1 && !visited[i][j]) {
                    q.add(bfs(world, visited, n, i, j));
                    count++;
                }
            }
        }
        System.out.println(count);
        while(!q.isEmpty()){
            System.out.println(q.poll());
        }

    }

    public static int bfs(int[][] world, boolean[][] visited, int n, int r, int c) {
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int count = 0;
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(r, c, 1));
        visited[r][c] = true;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            count++;
            for (int i = 0; i < dr.length; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= n) continue;

                if (!visited[nextR][nextC] && world[nextR][nextC] == 1) {
                    visited[nextR][nextC] = true;
                    q.add(new Pos(nextR, nextC, cur.dist + 1));
                }
            }
        }
        return count;
    }
}