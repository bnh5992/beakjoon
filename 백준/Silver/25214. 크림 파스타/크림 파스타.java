import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int min = nums[0];
        dp[0] = 0;
        sb.append(dp[0]).append(" ");
        for (int i = 1; i < n; i++) {
            if(nums[i] < min){
                min = nums[i];
                dp[i] = dp[i-1];
                sb.append(dp[i]).append(" ");
                continue;
            }
            if(dp[i-1] < nums[i]-min){
                dp[i] = nums[i]-min;
                sb.append(dp[i]).append(" ");
            }
            else{
                dp[i] = dp[i-1];
                sb.append(dp[i]).append(" ");
            }
        }
        System.out.println(sb);
    }
}