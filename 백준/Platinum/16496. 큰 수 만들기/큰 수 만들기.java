import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums.add(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < n-1; i++) {
            boolean flag = false;
            String cur = st.nextToken();
            for (int j = 0; j < nums.size(); j++) {
                BigInteger a = new BigInteger(Integer.toString(nums.get(j))+cur);
                BigInteger b = new BigInteger(cur + Integer.toString(nums.get(j)));
                if(a.compareTo(b) == -1){
                    nums.add(j, Integer.valueOf(cur));
                    flag = true;
                    break;
                }
            }
            if(!flag){
                nums.add(Integer.valueOf(cur));
            }

        }
        String stresult = "";
        for (int i = 0; i < nums.size(); i++) {
            stresult = stresult + Integer.toString(nums.get(i));
        }
        BigInteger result = new BigInteger(stresult);



        System.out.println(result);

    }
}