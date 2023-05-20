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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Pos> q = new LinkedList<>();
        Queue<Pos> wq = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        char[][] world = new char[n][m];
        for (int i = 0; i < n; i++) {
            String cur = br.readLine();
            for (int j = 0; j < m; j++) {
                world[i][j] = cur.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(world[i][j] == 'S'){
                    q.add(new Pos(i,j));
                    visited[i][j] = true;
                    continue;
                }
                if(world[i][j] == '*'){
                    wq.add(new Pos(i,j));
                    visited[i][j] = true;
                    continue;
                }
                if(world[i][j] == 'D' || world[i][j] == 'X'){
                    visited[i][j] = true;
                }
            }
        }

        int count = 1;
        while(true){
            int result = bfs(q,n,m,world,visited,1);
            if(result == 1){
                System.out.println(count);
                return;
            }
            else if(result == 2){
                System.out.println("KAKTUS");
                return;
            }
            bfs(wq,n,m,world,visited,0);


            count++;
        }

    }

    public static int bfs(Queue<Pos> q, int r, int c, char[][] world, boolean[][] visited, int signal){
        int[] DR = {1,0,-1,0};
        int[] DC = {0,1,0,-1};
        int size = q.size();
        while(!q.isEmpty()){
            if(size == 0) return 0;
            Pos Cur = q.poll();
            if(world[Cur.r][Cur.c] != 'S' && signal == 1){
                size--;
                continue;
            }
            for (int i = 0; i < DR.length; i++) {
                int nextR = Cur.r + DR[i];
                int nextC = Cur.c + DC[i];

                if(nextR < 0 || nextC < 0 || nextR >= r || nextC >= c) continue;

                if(world[nextR][nextC] == 'D'){
                    if(signal == 1){
                        return 1;
                    }
                    else{
                        continue;
                    }
                }
                if(world[nextR][nextC] == 'S' && signal == 0){
                    world[nextR][nextC] = '*';
                    q.add(new Pos(nextR,nextC));
                    continue;
                }

                if(!visited[nextR][nextC]){
                    if(signal == 1){
                        world[nextR][nextC] = 'S';
                    }
                    else{
                        world[nextR][nextC] = '*';
                    }
                    q.add(new Pos(nextR,nextC));
                    visited[nextR][nextC] = true;
                }
            }
            size--;
        }
        return 2;
    }
}