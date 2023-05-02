import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos{
        int r,c;
        Pos next;
        public Pos(int r, int c, Pos next){
            this.r = r;
            this.c = c;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Pos> array = new ArrayList<>();
        Queue<Pos> q = new LinkedList<>();
        boolean[][] visited = new boolean[n+1][n+1];
        boolean[][] lighting = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            array.add(new Pos(Integer.parseInt(st2.nextToken()),Integer.parseInt(st2.nextToken()),new Pos(Integer.parseInt(st2.nextToken()),Integer.parseInt(st2.nextToken()),null)));

        }
        q.add(new Pos(1,1,null));
        lighting[1][1] = true;
        visited[1][1] = true;
        int result = Bfs(array, q, visited,n,lighting);
        System.out.println(result);

    }

    public static int Bfs(ArrayList<Pos> array, Queue<Pos> q, boolean[][] visited, int n, boolean[][] lighting){
        int[] DR = {-1,0,1,0};
        int[] DC = {0,1,0,-1};
        int count = 1;
        while(!q.isEmpty()){
            Pos cur = q.poll();
            for (int j = 0; j < array.size(); j++) {
                if(!lighting[array.get(j).next.r][array.get(j).next.c] && cur.c == array.get(j).c &&cur.r == array.get(j).r){
                    lighting[array.get(j).next.r][array.get(j).next.c] = true;
                    for (int i = 0; i < DR.length; i++) {
                        int nR = array.get(j).next.r + DR[i];
                        int nC = array.get(j).next.c + DC[i];
                        if(nR < 1 || nC < 1 || nR >= n+1 || nC >= n+1 ) continue;

                        if(lighting[nR][nC] && visited[nR][nC]){
                            q.add(new Pos(array.get(j).next.r,array.get(j).next.c, null));
                            visited[array.get(j).next.r][array.get(j).next.c] = true;
                            break;
                        }
                    }
                    count++;
                }
            }

            for (int i = 0; i < DR.length; i++) {
                int nextR = cur.r + DR[i];
                int nextC = cur.c + DC[i];

                if(nextR < 1 || nextC < 1 || nextR >= n+1 || nextC >= n+1 ) continue;

                if(!visited[nextR][nextC] && lighting[nextR][nextC]){
                    q.add(new Pos(nextR,nextC,null));
                    visited[nextR][nextC] = true;
                }

            }
        }
        return count;
    }


}