import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node{
        int r,c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            char[][] world = new char[c][r];
            boolean[][] visited = new boolean[c][r];

            for (int j = 0; j < c; j++) {
                String s = br.readLine();
                for (int k = 0; k < r; k++) {
                    world[j][k] = s.charAt(k);
                    if(s.charAt(k) == '*'){
                        visited[j][k] = true;
                    }
                }
            }

            String key = br.readLine();
            for (int j = 0; j < key.length(); j++) {
                for (int k = 0; k < c; k++) {
                    for (int l = 0; l < r; l++) {

                        if(key.charAt(j) - 32 == world[k][l]){
                            world[k][l] = '.';
                        }
                    }
                }
            }
            int result = 0;
            int[] count = new int[2];
            while(true){
                boolean isClear = true;
                for (int j = 0; j < c; j++) {
                    for (int k = 0; k < r; k++) {
                        if(!visited[j][k] && (world[j][k] == '.' || world[j][k] == '$' || Character.isLowerCase(world[j][k])) && ((j == 0 || j == c-1) || (k == 0 || k == r-1))){
                            if(world[j][k] == '$'){
                                result++;
                                world[j][k] = '.';
                                visited[j][k] = true;
                            }

                            boolean hasKey = false;
                            if(world[j][k] != '.' && world[j][k] != '$' && Character.isLowerCase(world[j][k])){
                                for (int l = 0; l < key.length(); l++) {
                                    if(key.charAt(l) == world[j][k]){
                                        hasKey = true;
                                        break;
                                    }
                                }
                                if(!hasKey){
                                    for (int l = 0; l < c; l++) {
                                        for (int m = 0; m < r; m++) {
                                            if(world[l][m] == world[j][k] - 32){
                                                world[l][m] = '.';
                                            }
                                        }
                                    }
                                }
                            }
                            count = bfs(world, r, c, visited, new Node(j,k), key);
                            result += count[0];
                            isClear = false;
                            break;
                        }
                    }
                    if(!isClear) break;
                }
                if(count[1] > 0){
                    visited = new boolean[c][r];
                    for (int j = 0; j < c; j++) {
                        for (int k = 0; k < r; k++) {
                            if(world[j][k] == '*'){
                                visited[j][k] = true;
                            }
                        }
                    }
                }
                if(isClear) break;
            }


            sb.append(result + "\n");
        }
        System.out.print(sb);
    }

    public static int[] bfs(char[][] world, int r, int c, boolean[][] visited, Node start, String key){
        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};
        Queue<Node> q = new LinkedList<>();
        q.add(start);
        visited[start.r][start.c] = true;
        int[] count = new int[2];
        while(!q.isEmpty()){
            Node cur = q.poll();
            for (int i = 0; i < dr.length; i++) {
                int nextR = cur.r + dr[i];
                int nextC = cur.c + dc[i];

                if(nextR < 0 || nextC < 0 || nextC >= r || nextR >= c) continue;
                boolean isClear = false;
                if(!visited[nextR][nextC]){
                    if(world[nextR][nextC] != '.' && world[nextR][nextC] != '$'){
                        if(Character.isLowerCase(world[nextR][nextC])){
                            char nextKey = world[nextR][nextC];
                            world[nextR][nextC] = '.';
                            boolean hasKey = false;
                            for (int j = 0; j < key.length(); j++) {
                                if(nextKey == key.charAt(j)){
                                    hasKey = true;
                                    key += nextKey;
                                    break;
                                }
                            }
                            if(hasKey) {
                                visited[nextR][nextC] = true;
                                q.add(new Node(nextR, nextC));
                                continue;
                            }

                            for (int j = 0; j < c; j++) {
                                for (int k = 0; k < r; k++) {
                                    if(nextKey - 32 == world[j][k]){
                                        world[j][k] = '.';
                                    }
                                }
                            }
                            isClear = true;
                        }

                        else{
                            continue;
                        }
                    }
                    if(world[nextR][nextC] == '$'){
                        world[nextR][nextC] = '.';
                        count[0]++;
                    }
                    visited[nextR][nextC] = true;
                    q.add(new Node(nextR, nextC));
                }
                if(isClear){
                    count[1]++;
                }
            }
        }
        return count;
    }
}