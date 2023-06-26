import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int home = Integer.parseInt(br.readLine());
        int[][] dp = new int[home][3];

        for (int i = 0; i < home; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < home; i++) {
            for (int j = 0; j < 3; j++) {
                if(j == 0){
                    dp[i][j] += Math.min(dp[i-1][2], dp[i-1][1]);
                }
                if(j == 1){
                    dp[i][j] += Math.min(dp[i-1][0], dp[i-1][2]);
                }
                if(j == 2){
                    dp[i][j] += Math.min(dp[i-1][0], dp[i-1][1]);
                }
            }
        }

        System.out.println(Math.min(dp[home-1][0], Math.min(dp[home-1][1], dp[home-1][2])));
    }
}