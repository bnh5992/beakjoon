import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static class building{
        int pos;
        int height;
        public building(int pos, int height){
            this.pos = pos;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int buildings = Integer.parseInt(br.readLine());
        int[] floor = new int[buildings];
        for (int i = 0; i < buildings; i++) {
            floor[i] = Integer.parseInt(br.readLine());
        }

        long result = 0;
        Stack<building> st = new Stack<>();
        for (int i = 0; i < buildings; i++) {

            while(!st.isEmpty()){
                if(st.peek().height <= floor[i]){
                    result += i - st.peek().pos - 1;
                    st.pop();
                }
                else{
                    break;
                }

            }
            st.add(new building(i, floor[i]));
        }
        while(!st.isEmpty()){
            result += buildings-st.pop().pos - 1;
        }
        System.out.println(result);
    }
}