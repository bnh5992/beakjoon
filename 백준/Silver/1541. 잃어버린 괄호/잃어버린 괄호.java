import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String form = br.readLine();

        int result = 0;
        String numA = "";
        boolean isPlus = true;
        boolean isFirst = true;
        for (int i = 0; i < form.length(); i++) {
            if (form.charAt(i) == '+') {
                if(!isPlus){
                    result -= Integer.parseInt(numA);
                    numA = "";
                    continue;
                }
                else{
                    result += Integer.parseInt(numA);
                }

                numA = "";
                continue;
            }
            if (form.charAt(i) == '-') {
                isPlus = false;
                if(isFirst){
                    result += Integer.parseInt(numA);
                    numA = "";
                    isFirst = false;
                    continue;
                }
                result -= Integer.parseInt(numA);
                numA = "";
                continue;
            }

            numA = numA + form.charAt(i);
        }
        if(isPlus){
            result += Integer.parseInt(numA);
        }
        else{
            result -= Integer.parseInt(numA);
        }

        System.out.println(result);
    }
}