import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int books = Integer.parseInt(st.nextToken());
        int carrier = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> plusQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQ = new PriorityQueue<>();
        ArrayList<Integer> arr = new ArrayList<>();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <books ; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num < 0){
                minusQ.add(num);
            }
            else{
                plusQ.add(num);
            }
            arr.add(num);
        }
        Collections.sort(arr);


        int re = 0;
        if(arr.get(arr.size() -1) >= Math.abs(arr.get(0))){
            re = cal(plusQ, minusQ, carrier);
        }
        else{
            re = cal(minusQ, plusQ, carrier);
        }
        System.out.println(re);


    }

    public static int cal(PriorityQueue<Integer> plusQ, PriorityQueue<Integer> minusQ, int carrier){
        int result = 0;
        ArrayList<Integer> a = null;
        while(!minusQ.isEmpty()){
            a = new ArrayList<>();
            for (int i = 0; i < carrier; i++) {
                if(minusQ.isEmpty()) break;
                a.add(minusQ.poll());
            }
            result += Math.abs(a.get(0))*2;
        }
        boolean isFirst = true;
        if(plusQ.size() % carrier != 0){
            a = new ArrayList<>();
            for (int i = 0; i < carrier; i++) {
                if(plusQ.isEmpty()) break;
                a.add(plusQ.poll());
            }
            result += Math.abs(a.get(0));
            isFirst = false;
        }


        while(!plusQ.isEmpty()){
            a = new ArrayList<>();
            for (int i = 0; i < carrier; i++) {
                if(plusQ.isEmpty()) break;
                a.add(plusQ.poll());
            }
            if(isFirst){
                result += Math.abs(a.get(0));
                isFirst = false;
            }
            else{
                result += Math.abs(a.get(0))*2;
            }
        }
        return result;
    }
}