import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[r][c];
        int[][] world = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int now = Integer.parseInt(st.nextToken());
                world[i][j] = now;
                if (now == 1) {
                    visited[i][j] = true;
                }
            }
        }


        int result = 0;
        while (true) {
            boolean isClear = true;
            boolean[][] visit = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    visit[i][j] = visited[i][j];
                }
            }


            int[][] counting = bfs(world, r, c, visit);

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (counting[i][j] >= 2) {
                        world[i][j] = 0;
                        visited[i][j] = false;
                    }

                    if (world[i][j] != 0) {
                        isClear = false;
                    }
                }
            }

            if (isClear) {
                System.out.println(result + 1);
                return;
            }


            result++;

        }

    }

    public static int[][] bfs(int[][] world, int r, int c, boolean[][] visited) {
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int[][] counting = new int[r][c];
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0));
        visited[0][0] = true;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int i = 0; i < dr.length; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if (nextR < 0 || nextC < 0 || nextR >= r || nextC >= c) continue;

                if (!visited[nextR][nextC]) {
                    q.add(new Pos(nextR, nextC));
                    visited[nextR][nextC] = true;
                }

                if (world[nextR][nextC] == 1) {
                    counting[nextR][nextC]++;
                }
            }
        }
        return counting;
    }
}