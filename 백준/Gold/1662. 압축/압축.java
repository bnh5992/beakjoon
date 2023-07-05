import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<String> st = new Stack<>();
        ArrayList<Integer> array = new ArrayList<>();
        int[] countingOther = new int[50];

        int j = 0;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                array.add(Integer.valueOf(st.pop()));
                countingOther[j]--;
                j++;
                continue;
            }
            if (str.charAt(i) == ')') {
                count = array.get(array.size() - 1) * countingOther[j];
                countingOther[j] = 0;
                array.remove(array.size() - 1);
                j--;
                countingOther[j] += count;
                continue;
            }
            st.add(String.valueOf(str.charAt(i)));
            countingOther[j]++;
        }

        System.out.println(countingOther[0]);
    }
}