import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] world = new int[n][n];
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                world[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == n-1 && j == n-1) break;
                if(dp[i][j] == 0) continue;
                if(i+world[i][j] >= n || j+world[i][j] >= n){
                    if(i+world[i][j] >= n && j+world[i][j] >= n) continue;
                    if(i+world[i][j] >= n){
                        if(dp[i][j+world[i][j]] == 0){
                            dp[i][j+world[i][j]] = dp[i][j];
                        }
                        else{
                            dp[i][j+world[i][j]] = dp[i][j+world[i][j]]+dp[i][j];
                        }
                    }
                    else{
                        if(dp[i+world[i][j]][j] == 0){
                            dp[i+world[i][j]][j] = dp[i][j];
                        }
                        else{
                            dp[i+world[i][j]][j] = dp[i+world[i][j]][j]+dp[i][j];
                        }

                    }
                }
                else {
                    if(dp[i+world[i][j]][j] == 0){
                        dp[i+world[i][j]][j] = dp[i][j];
                    }
                    else{
                        dp[i+world[i][j]][j] = dp[i+world[i][j]][j]+dp[i][j];
                    }
                    if(dp[i][j+world[i][j]] == 0){
                        dp[i][j+world[i][j]] = dp[i][j];
                    }
                    else{
                        dp[i][j+world[i][j]] =  dp[i][j+world[i][j]]+dp[i][j];
                    }
                }
            }
        }
        if(dp[n-1][n-1] == 0){
            System.out.println(0);
        }
        else{
            System.out.println(dp[n-1][n-1]);
        }

    }
}