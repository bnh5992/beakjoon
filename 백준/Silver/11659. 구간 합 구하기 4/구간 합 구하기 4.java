import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int nums = Integer.parseInt(st.nextToken());
        int[] sums = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        sums[1] = Integer.parseInt(st.nextToken());
        for (int i = 2; i < n+1; i++) {
            sums[i] = sums[i-1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < nums; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append((sums[end]-sums[start-1]) + "\n");
        }
        System.out.print(sb);
    }
}