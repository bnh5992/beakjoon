import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Pos{
        int x, dist;
        public Pos(int x, int dist){
            this.x = x;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int suBin = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[100002];


        bfs(visit , suBin, target);

    }

    public static void bfs(boolean[] visit, int start, int target) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(start, 0));


        int[] moving = {1, -1, 2};
        while (!q.isEmpty()) {

            Pos cur = q.poll();
            visit[cur.x] = true;

            if(cur.x == target){
                int time = cur.dist;
                int count = 1;
                while(!q.isEmpty()){
                    Pos next = q.poll();
                    if(target == next.x && cur.dist == next.dist){
                        count++;
                    }
                }
                System.out.println(time);
                System.out.println(count);
                return;
            }
            for (int i = 0; i < moving.length; i++) {
                int nextMove;
                if (i == moving.length - 1) {
                    nextMove = cur.x * moving[i];
                } else {
                    nextMove = cur.x + moving[i];
                }
                if (nextMove < 0 || nextMove > 100000) continue;

                if(!visit[nextMove]){
                    q.add(new Pos(nextMove, cur.dist+1));
                }


            }


        }

    }
}