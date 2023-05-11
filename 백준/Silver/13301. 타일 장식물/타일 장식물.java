import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];
        long[] fibo = new long[n+1];
        dp[0] = 4;
        dp[1] = 6;
        fibo[0] = 1;
        fibo[1] = 1;


        for (int i = 2; i < n; i++) {
            fibo[i] = fibo[i-1] + fibo[i-2];
            dp[i] = dp[i-1] + 2*fibo[i];
        }
        System.out.println(dp[n-1]);
    }
}