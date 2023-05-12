import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int max = nums[0];
        int min = nums[0];
        int result = 1;
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i] == max){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1] + 1;
            }
            else if(nums[i] > max){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = 1;
            }
            else if(nums[i] < min){
                dp[i][1] = dp[i-1][1] + 1;
                dp[i][0] = 1;
            }
            max = nums[i];
            min = nums[i];

            result = Math.max(Math.max(dp[i][1],dp[i][0]),result);


        }
        System.out.println(result);


    }
}