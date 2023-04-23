import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        long money = Integer.parseInt(st.nextToken());
        int[] price = new int[day];
        for (int i = 0; i < day ; i++) {
            price[i] = Integer.parseInt(br.readLine());
        }
        int nowdays = 0;
        long coins = 0;
        boolean first = true;
        while (true){
            if(nowdays >= day-1) break;
            int curprice = price[nowdays];
            if(coins == 0){
                while(true){
                    if(curprice < price[nowdays]){
                        break;
                    }
                    else{
                        curprice = price[nowdays];
                        nowdays++;
                    }
                    if(nowdays >= day){
                        System.out.println(money);
                        return;
                    }
                }
                coins = money/curprice;
                money = money%curprice;
            }
            else{
                while(true){
                    if(curprice > price[nowdays]) break;
                    else{
                        curprice = price[nowdays];
                        nowdays++;
                    }
                    if(nowdays >= day){
                        money = money + coins*price[day-1];
                        System.out.println(money);
                        return;
                    }
                }
                money = money + coins*curprice;
                coins = 0;
            }
        }
        money = money + coins*price[day-1];
        System.out.println(money);

    }
}