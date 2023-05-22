import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for (int i = 0; i <N ; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        int front = 0;
        int back = N-1;
        int diff = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        while(true){
            if(front==back) break;
            if(nums[front]+nums[back]<0){
                if(Math.abs(nums[front]+nums[back])<diff){
                    diff = Math.abs(nums[front]+nums[back]);
                    a = nums[front];
                    b = nums[back];
                }
                front++;
            }
            else{
                if(Math.abs(nums[front]+nums[back])<diff){
                    diff = Math.abs(nums[front]+nums[back]);
                    a = nums[front];
                    b = nums[back];
                }
                back--;
            }
        }
        System.out.print(a+" " + b);
    }
}