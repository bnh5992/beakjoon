import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] world = new int[n][n];
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world.length; j++) {
                world[i][j] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            int row = world.length - 1;
            int col = 0;
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            for (int j = 0; j < zero; j++) {
                if (row > 0) {
                    row--;
                } else {
                    col++;
                }
            }
            for (int j = 0; j < first; j++) {
                if (row > 0) {
                    world[row][col] += 1;
                    row--;
                } else {
                    world[0][col] += 1;
                    col++;
                }
            }
            for (int j = 0; j < second; j++) {
                if (row > 0) {
                    world[row][col] += 2;
                    row--;
                } else {
                    world[0][col] += 2;
                    col++;
                }
            }
        }

        for (int i = 1; i < world.length; i++) {
            for (int j = 1; j < world.length; j++) {
                world[j][i] = world[0][i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < world.length; i++) {
            for (int j = 0; j < world.length; j++) {
                sb.append(world[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}