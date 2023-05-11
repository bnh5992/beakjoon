import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] dp = new String[1001];
        dp[1] = "CY";
        dp[2] = "SK";
        dp[3] = "CY";
        dp[4] = "SK";
        for (int i = 5; i < n+1; i++) {
            if(dp[i-1].equals("CT")||dp[i-3].equals("CY")){
                dp[i] = "SK";
            }
            else{
                dp[i] = "CY";
            }
        }
        System.out.println(dp[n]);
    }
}