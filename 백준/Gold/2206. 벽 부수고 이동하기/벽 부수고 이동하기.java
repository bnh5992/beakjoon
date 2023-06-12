import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos {
        int r, c, dist;
        boolean broken;

        public Pos(int r, int c, boolean broken, int dist) {
            this.r = r;
            this.c = c;
            this.broken = broken;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] world = new int[r][c];
        boolean[][][] visited = new boolean[2][r][c];
        for (int i = 0; i < r; i++) {
            String col = br.readLine();
            for (int j = 0; j < col.length(); j++) {
                world[i][j] = Integer.parseInt(String.valueOf(col.charAt(j)));
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(world[i][j] == 1){
                    visited[0][i][j] = true;
                    visited[1][i][j] = true;
                }
            }
        }


        if(!bfs(world,r,c,visited)){
            System.out.println(-1);
        };
    }

    public static boolean bfs(int[][] world, int r, int c, boolean[][][] visited) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0,0,false,0));
        visited[0][0][0] = true;
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if(cur.r == r-1 && cur.c == c-1){
                System.out.println(cur.dist+1);
                return true;
            }


            for (int i = 0; i < dr.length; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if (nextR < 0 || nextC < 0 || nextR >= r || nextC >= c) continue;

                if(cur.broken){
                    if(!visited[1][nextR][nextC]){
                        q.add(new Pos(nextR, nextC, true, cur.dist + 1));
                        visited[1][nextR][nextC] = true;
                        continue;
                    }
                }
                else{
                    if (!visited[0][nextR][nextC]) {
                        q.add(new Pos(nextR, nextC, false, cur.dist + 1));
                        visited[0][nextR][nextC] = true;
                        continue;
                    }
                }


                if (world[nextR][nextC] == 1 && !cur.broken) {
                    q.add(new Pos(nextR, nextC, true, cur.dist + 1));
                }

            }
        }
        return false;
    }
}