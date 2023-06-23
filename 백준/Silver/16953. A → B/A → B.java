import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Pos{
        BigInteger num;
        int count;
        public Pos(BigInteger num, int count){
            this.num = num;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger start = new BigInteger(st.nextToken());
        BigInteger end = new BigInteger(st.nextToken());
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(start, 0));
        bfs(q, end);
    }

    public static void bfs(Queue<Pos> q, BigInteger end){
        BigInteger maxInt = new BigInteger("10000000000");
        while(!q.isEmpty()){
            Pos cur = q.poll();
            if(cur.num.compareTo(end) == 0){
                System.out.println(cur.count+1);
                return;
            }

            for (int i = 0; i < 2; i++) {
                BigInteger nextNum = new BigInteger("0");
                if(i == 0){
                    nextNum = cur.num.multiply(BigInteger.valueOf(2));
                }
                if(i == 1){
                    nextNum = cur.num.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(1));
                }
                if(nextNum.compareTo(maxInt) == 0) continue;
                if(nextNum.compareTo(end) == 1) continue;
                q.add(new Pos(nextNum, cur.count+1));


            }
        }
        System.out.println(-1);
    }

}