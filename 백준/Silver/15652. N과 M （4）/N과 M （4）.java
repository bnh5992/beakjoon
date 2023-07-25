import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] arr;
    public static int N;
    public static int M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N  = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        backTracking(1, 0);
        System.out.println(sb);
    }

    public static void backTracking(int n, int r){
        if(r == M){
            for (int val: arr
            ) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = n; i < N+1; i++) {
            arr[r] = i;
            backTracking(i, r+1);
        }
    }
}