import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Long[] dp = new Long[10000];
        int test = Integer.parseInt(br.readLine());
        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;
        dp[4] = 2L;
        for (int i = 0; i < test; i++) {
            int num = Integer.parseInt(br.readLine());
            for (int j = 5; j < num+1; j++) {
                dp[j] = dp[j-1] + dp[j-5];
            }
            sb.append(dp[num] + "\n");
        }
        System.out.print(sb);
    }
}