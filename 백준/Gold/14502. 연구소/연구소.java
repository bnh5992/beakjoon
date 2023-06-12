import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] world = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        ArrayList<Pos> array = new ArrayList<>();
        int max = 0;
        Queue<Pos> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                world[i][j] = num;
                if (num == 1) {
                    visited[i][j] = true;
                }
                if (num == 2) {
                    visited[i][j] = true;
                    array.add(new Pos(i, j));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean sfirst = true;
                if(visited[i][j]) continue;

                for (int k = i; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if(sfirst){
                            l = j;
                            sfirst = false;
                            continue;
                        }
                        boolean tfirst = true;
                        if(visited[k][l]) continue;

                        for (int o = k; o < n; o++) {
                            for (int p = 0; p < m; p++) {
                                if(tfirst){
                                    p = l;
                                    tfirst = false;
                                    continue;
                                }
                                if(visited[o][p]) continue;


                                boolean[][] visit = new boolean[n][m];
                                int[][] sample = new int[n][m];
                                for (int r = 0; r < n; r++) {
                                    for (int s = 0; s < m; s++) {
                                        visit[r][s] = visited[r][s];
                                        sample[r][s] = world[r][s];
                                    }
                                }

                                visit[o][p] = true;
                                visit[k][l] = true;
                                visit[i][j] = true;
                                sample[o][p] = 1;
                                sample[k][l] = 1;
                                sample[i][j] = 1;

                                for (int r = 0; r < array.size(); r++) {
                                    q.add(array.get(r));
                                }
                                Bfs(q,sample,n,m,visit);
                                int count = 0;
                                for (int r = 0; r < n; r++) {
                                    for (int s = 0; s < m; s++) {
                                        if (sample[r][s] == 0) {
                                            count++;
                                        }
                                    }
                                }
                                max = Math.max(max, count);

                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);



    }


    public static void Bfs(Queue<Pos> q, int[][] world, int n, int m, boolean[][] visited) {
        int[] DR = {-1, 0, 1, 0};
        int[] DC = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int i = 0; i < DR.length; i++) {
                int nextR = cur.r + DR[i];
                int nextC = cur.c + DC[i];

                if (nextR < 0 || nextC < 0 || nextR >= n || nextC >= m) continue;

                if (!visited[nextR][nextC]) {
                    q.add(new Pos(nextR, nextC));
                    visited[nextR][nextC] = true;
                    world[nextR][nextC] = 2;
                }
            }
        }
    }
}