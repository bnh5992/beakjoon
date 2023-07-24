import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[1000002];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i < n+1; i++) {
            dp[i] = (i-1)*dp[i-1] + (i-1)*dp[i-2];
            dp[i] = dp[i]%1000000000;
        }
        System.out.println(dp[n]);
    }
}