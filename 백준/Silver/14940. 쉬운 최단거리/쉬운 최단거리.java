import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Pos> q = new LinkedList<>();
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        boolean[][] visited = new boolean[r][c];
        int[][] world = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int a = Integer.parseInt(st.nextToken());
                world[i][j] = a;
                if (a == 0) {
                    visited[i][j] = true;
                }
                if (a == 2) {
                    q.add(new Pos(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        int[][] nowWorld = bfs(q,r,c,visited);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!visited[i][j] && nowWorld[i][j] == 0){
                    nowWorld[i][j] = -1;
                }
                System.out.print(nowWorld[i][j]+" ");
            }
            System.out.println();
        }


    }

    public static int[][] bfs(Queue<Pos> q, int r, int c, boolean[][] visited) {
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int[][] scaleWorld = new int[r][c];
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            scaleWorld[cur.r][cur.c] = cur.dist;
            for (int i = 0; i < dr.length; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if (nextR < 0 || nextC < 0 || nextR >= r || nextC >= c) continue;

                if (!visited[nextR][nextC]) {
                    q.add(new Pos(nextR, nextC, cur.dist + 1));
                    visited[nextR][nextC] = true;
                }
            }
        }
        return scaleWorld;
    }
}