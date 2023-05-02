import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Pos{
        int r,c;
        String now;
        public Pos(int r,int c, String now){
            this.r = r;
            this.c = c;
            this.now = now;
        }
    }
    public static final int[] DR = {1,0,-1,0};
    public static final int[] DC = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Pos> q = new LinkedList<>();
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[][] maze = new String[r][c];
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String[] a = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if(a[j].equals("#")){
                    visited[i][j] = true;
                }
                if(a[j].equals("W")){
                    visited[i][j] = true;
                    q.add(new Pos(i,j,"W"));
                }
                maze[i][j] = a[j];
            }
        }
        Bfs(maze,r,c,q,visited);

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(!visited[i][j] && !maze[i][j].equals("+")){
                    maze[i][j] = "P";
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }


    }

    public static void Bfs(String[][] maze, int R, int C, Queue<Pos> q, boolean[][] visited){
        while(!q.isEmpty()){
            Pos Cur = q.poll();
            for (int i = 0; i < DR.length; i++) {
                int NextR = Cur.r + DR[i];
                int NextC = Cur.c + DC[i];

                if(NextR < 0 || NextR >=R || NextC < 0 || NextC >=C || visited[NextR][NextC]) continue;

                if(maze[NextR][NextC].equals("+")){
                    while(true){
                        if(maze[NextR][NextC].equals("#")){
                            if(!visited[NextR - DR[i]][NextC - DC[i]]){
                                NextR = NextR - DR[i];
                                NextC = NextC - DC[i];
                                visited[NextR][NextC] = true;
                                q.add(new Pos(NextR,NextC,maze[NextR][NextC]));
                            }
                            break;
                        }
                        if(maze[NextR][NextC].equals(".") && !visited[NextR][NextC]) {
                            visited[NextR][NextC] = true;
                            q.add(new Pos(NextR,NextC,maze[NextR][NextC]));
                            break;
                        }

                        NextR = NextR + DR[i];
                        NextC = NextC + DC[i];
                    }
                    continue;
                }
                if(maze[NextR][NextC].equals(".") && !visited[NextR][NextC]){
                    visited[NextR][NextC] = true;
                    q.add(new Pos(NextR,NextC,maze[NextR][NextC]));
                }
            }
        }
    }
}