import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] money = new int[n];
        int[] remainmoney = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            money[i] = a;
            remainmoney[i] = a;
        }

        int fullmoney = Integer.parseInt(br.readLine());

        int remain = 0;
        int givemoney = fullmoney;
        boolean[] isfull = new boolean[n];
        int maxmoney = 0;
        while(true){
            int dividenum = 0;
            for (int i = 0; i < n; i++) {
                if(!isfull[i]) dividenum++;
            }

            if(dividenum == 0){
                maxmoney = 0;
                for (int i = 0; i < n; i++) {
                    maxmoney = Math.max(maxmoney, money[i]);
                }
                System.out.println(maxmoney);
                return;
            }

            givemoney = fullmoney / dividenum;
            maxmoney = maxmoney + givemoney;
            remain = fullmoney % dividenum;

            if(givemoney == 0) break;
            for (int i = 0; i < n; i++) {
                if(!isfull[i]){
                    if(remainmoney[i] < givemoney){
                        remain = remain + givemoney - remainmoney[i];
                        isfull[i] = true;
                    }
                    else{
                        remainmoney[i] = remainmoney[i] - givemoney;
                    }
                }
            }

            fullmoney = remain;
        }
        System.out.println(maxmoney);

    }
}