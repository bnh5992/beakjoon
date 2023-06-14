import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String math = br.readLine();

        int gggg = 0;

        Stack<Character>[] gstack = new Stack[100];
        gstack[0] = new Stack<>();
        for (int i = 0; i < math.length(); i++) {
            char pixel = math.charAt(i);
            if (pixel == '*' || pixel == '/' || pixel == '+' || pixel == '-') {
                st(gstack[gggg], pixel);
            } else if (pixel == '(') {
                gggg++;
                gstack[gggg] = new Stack<>();
            } else if (pixel == ')') {
                while (!gstack[gggg].isEmpty()) {
                    sb.append(gstack[gggg].pop());
                }
                gggg--;
            } else {
                sb.append(pixel);
            }

        }
        while (!gstack[gggg].isEmpty()) {
            sb.append(gstack[gggg].pop());
        }
        System.out.println(sb);
    }

    public static void st(Stack<Character> stack, char pixel) {
        boolean isPop = false;
        if (stack.isEmpty()) {
            stack.add(pixel);
            return;
        }
        while (!stack.isEmpty()) {
            if ((stack.peek() == '+' || stack.peek() == '-') && (pixel == '*' || pixel == '/')) {
                isPop = true;
                stack.add(pixel);
                break;
            } else {
                sb.append(stack.pop());
            }
        }
        if (!isPop) {
            stack.add(pixel);
        }
    }
}