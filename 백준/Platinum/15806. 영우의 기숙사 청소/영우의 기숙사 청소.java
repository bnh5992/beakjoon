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
        Queue<Pos> q = new LinkedList<>();
        Queue<Pos> check = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int mold = Integer.parseInt(st.nextToken());
        int inspectorNum = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        boolean[][][] world = new boolean[2][n+1][n+1];

        for (int i = 0; i < mold; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st2.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            world[0][r-1][c-1] = true;
            q.add(new Pos(r-1,c-1));
        }
        for (int i = 0; i < inspectorNum; i++) {
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            check.add(new Pos(Integer.parseInt(st3.nextToken())-1,Integer.parseInt(st3.nextToken())-1));
        }

        if(n <= 3){
            boolean[][] world2 = new boolean[n+1][n+1];
            SmallBFS(q,n,world2,time);
            if(checkSmallFloor(check,world2)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            return;
        }
        else{
            BFS(q,n,world,time);
        }

        if(checkFloor(check,world,time)){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }


    }

    public static void BFS(Queue<Pos> q, int n, boolean[][][] world,int time){
        int[] DR = {-2,-2,-1,-1,1,1,2,2};
        int[] DC = {1,-1,2,-2,2,-2,1,-1};
        int start = q.size();
        int ending = 0;
        while(!q.isEmpty()){
            Pos cur = q.poll();
            if(start == 0){
                start = q.size();
                ending++;
            }
            if(time == ending){
                return;
            }
            for (int i = 0; i < DR.length; i++) {
                int nextR = cur.r + DR[i];
                int nextC = cur.c + DC[i];

                if(nextR < 0 || nextC < 0 || nextR >= n || nextC >= n) continue;
                if(world[(ending+1)%2][nextR][nextC]) continue;

                if(world[ending%2][nextR][nextC]){
                    world[(ending+1)%2][nextR][nextC] = true;
                    q.add(new Pos(nextR, nextC));
                }
            }
            start--;
        }
    }

    public static void SmallBFS(Queue<Pos> q, int n, boolean[][] world,int time){
        int[] DR = {-2,-2,-1,-1,1,1,2,2};
        int[] DC = {1,-1,2,-2,2,-2,1,-1};
        int start = q.size();
        int ending = 0;
        while(!q.isEmpty()){
            Pos cur = q.poll();
            world[cur.r][cur.c] = false;
            if(start == 0){
                start = q.size();
                ending++;
            }
            if(time == ending){
                return;
            }
            for (int i = 0; i < DR.length; i++) {
                int nextR = cur.r + DR[i];
                int nextC = cur.c + DC[i];

                if(nextR < 0 || nextC < 0 || nextR >= n || nextC >= n) continue;

                if(world[nextR][nextC]){
                    world[nextR][nextC] = true;
                    q.add(new Pos(nextR, nextC));
                }
            }
            start--;
        }
    }

    public static boolean checkFloor(Queue<Pos> q, boolean[][][] world, int time){
        while(!q.isEmpty()){
            Pos now = q.poll();
            if(world[time%2][now.r][now.c]){
                return true;
            }
        }
        return false;
    }

    public static boolean checkSmallFloor(Queue<Pos> q, boolean[][] world){
        while(!q.isEmpty()){
            Pos now = q.poll();
            if(world[now.r][now.c]){
                return true;
            }
        }
        return false;
    }
}