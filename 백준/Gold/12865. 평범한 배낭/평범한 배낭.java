import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(st.nextToken());
        int[][] object = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            object[i][0] = Integer.parseInt(st.nextToken());
            object[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][price + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= price; j++) {
                if (object[i][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - object[i][0]] + object[i][1]);
                }
            }
        }
        System.out.println(dp[n][price]);
    }
}