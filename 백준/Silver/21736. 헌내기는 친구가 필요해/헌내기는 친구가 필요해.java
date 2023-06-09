import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos{
        int r,c;
        public Pos(int r, int c){
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
        char[][] world = new char[r][c];

        Queue<Pos> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String col = br.readLine();
            for (int j = 0; j < col.length(); j++) {
                world[i][j] = col.charAt(j);
                if(col.charAt(j) == 'X'){
                    visited[i][j] = true;
                }
                if(col.charAt(j) == 'I'){
                    q.add(new Pos(i,j));
                }
            }
        }
        int result = bfs(world, visited,r,c,q);
        if(result == 0){
            System.out.println("TT");
        }
        else{
            System.out.println(result);
        }


    }

    public static int bfs(char[][] world, boolean[][] visited, int r, int c, Queue<Pos> q){
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        int count = 0;
        while(!q.isEmpty()){
            Pos cur = q.poll();
            for (int i = 0; i < dr.length; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR < 0 || nextC < 0 || nextR >= r || nextC >= c) continue;

                if(!visited[nextR][nextC]){
                    visited[nextR][nextC] = true;
                    if(world[nextR][nextC] == 'P'){
                        count++;
                    }
                    q.add(new Pos(nextR, nextC));

                }
            }
        }
        return count;
    }
}