import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class MM {
        int max, min;

        public MM(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] world = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            world[i][0] = Integer.parseInt(st.nextToken());
            world[i][1] = Integer.parseInt(st.nextToken());
            world[i][2] = Integer.parseInt(st.nextToken());
        }

        ArrayList<MM>[] dp = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new ArrayList<>();
        }

        dp[0].add(new MM(world[0][0], world[0][0]));
        dp[0].add(new MM(world[0][1], world[0][1]));
        dp[0].add(new MM(world[0][2], world[0][2]));
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i].add(new MM(Math.max(dp[i - 1].get(0).max, dp[i - 1].get(1).max) + world[i][j],
                            Math.min(dp[i - 1].get(0).min, dp[i - 1].get(1).min) + world[i][j]));
                }
                if (j == 1) {
                    dp[i].add(new MM(Math.max(dp[i - 1].get(0).max, Math.max(dp[i - 1].get(1).max, dp[i - 1].get(2).max)) + world[i][j],
                            Math.min(dp[i - 1].get(0).min, Math.min(dp[i - 1].get(1).min, dp[i - 1].get(2).min)) + world[i][j]));
                }
                if (j == 2) {
                    dp[i].add(new MM(Math.max(dp[i - 1].get(2).max, dp[i - 1].get(1).max) + world[i][j],
                            Math.min(dp[i - 1].get(2).min, dp[i - 1].get(1).min) + world[i][j]));
                }
            }
        }
        System.out.print(Math.max(dp[n - 1].get(0).max, Math.max(dp[n - 1].get(1).max, dp[n - 1].get(2).max)));
        System.out.println(" " + Math.min(dp[n - 1].get(0).min, Math.min(dp[n - 1].get(1).min, dp[n - 1].get(2).min)));
    }
}