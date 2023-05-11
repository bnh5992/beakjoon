import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            BigInteger sum = new BigInteger("1");
            for (int j = 1; j < b+1; j++) {
                sum =  sum.multiply(BigInteger.valueOf(j));
            }
            for (int j = 1; j < a+1; j++) {
                sum = sum.divide(BigInteger.valueOf(j));
            }
            for (int j = 1; j < b-a+1; j++) {
                sum = sum.divide(BigInteger.valueOf(j));
            }
            System.out.println(sum);
        }

    }
}