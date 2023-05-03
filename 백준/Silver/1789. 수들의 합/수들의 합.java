import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong((br.readLine()));
        int count = 0;
        while(true){
            if((Math.pow(count, 2) + count)/2 > n) break;
            count++;
        }
        System.out.println(count-1);
    }
}