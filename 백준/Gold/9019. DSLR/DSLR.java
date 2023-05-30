import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static class Pos{
        int x;
        String dist;
        public Pos(int x, String dist){
            this.x = x;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());



        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[10000];
            Queue<Pos> q = new LinkedList<>();
            q.add(new Pos(start, ""));

            String result = bfs(q, visited, end);
            sb.append(result+"\n");

        }
        System.out.print(sb);
    }

    public static String bfs(Queue<Pos> q, boolean[] visited, int end){
        while(!q.isEmpty()){
            Pos cur = q.poll();

            if(cur.x == end){
                return cur.dist;
            }

            int nextD = D(cur.x);
            int nextS = S(cur.x);
            int nextL = L(cur.x);
            int nextR = R(cur.x);

            if(!visited[nextD]){
                q.add(new Pos(nextD, cur.dist+"D"));
                visited[nextD] = true;
            }
            if(!visited[nextS]){
                q.add(new Pos(nextS, cur.dist+"S"));
                visited[nextS] = true;
            }
            if(!visited[nextL]){
                q.add(new Pos(nextL, cur.dist+"L"));
                visited[nextL] = true;
            }
            if(!visited[nextR]){
                q.add(new Pos(nextR, cur.dist+"R"));
                visited[nextR] = true;
            }



        }
        return null;

    }



    public static int D(int num){
        return (num * 2)%10000;
    }
    public static int S(int num){
        if(num == 0){
            return 9999;
        }
        return num - 1;
    }

    public static int R(int num){
        int floor = num % 10;
        int lower = num /10;
        return lower + floor*1000;
    }

    public static int L(int num){
        int floor = num % 1000;
        int lower = num /1000;
        return lower + floor*10;
    }

}