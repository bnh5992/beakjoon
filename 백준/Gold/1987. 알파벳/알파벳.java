import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[] DR = {0, 1, 0, -1};
    static final int[] DC = {1, 0, -1, 0};
    static char[][] world;
    static boolean[] visited;
    static int R;
    static int C;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        world = new char[R][C];
        visited = new boolean[26];
        for (int i = 0; i < R; i++) {
            String col = br.readLine();
            for (int j = 0; j < C; j++) {
                world[i][j] = col.charAt(j);
            }
        }

        DFS(0, 0, 1);

        System.out.println(result);
    }

    static void DFS(int r, int c, int depth) {
        visited[world[r][c] - 'A'] = true;
        for (int i = 0; i < DR.length; i++) {
            int nextR = r + DR[i];
            int nextC = c + DC[i];

            if (nextR < 0 || nextC < 0 || nextR >= R || nextC >= C) {
                result = Math.max(result, depth);
                continue;
            }


            if(visited[world[nextR][nextC] - 'A']){
                result = Math.max(result, depth);
                continue;
            }
            DFS(nextR, nextC, depth + 1);

        }
        visited[world[r][c] - 'A'] = false;
    }
}