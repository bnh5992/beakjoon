import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class zombie {
        int locate;
        int health;

        public zombie(int locate, int health) {
            this.locate = locate;
            this.health = health;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int load = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int range = Integer.parseInt(st.nextToken());
        int damage = Integer.parseInt(st.nextToken());
        int boom = Integer.parseInt(br.readLine());

        Queue<zombie> q = new LinkedList<>();
        for (int i = 0; i < load; i++) {
            st = new StringTokenizer(br.readLine());
            q.add(new zombie(i, Integer.parseInt(st.nextToken())));
        }


        int penalty = 0;
        boolean isPenalty = false;
        Queue<Integer> p = new LinkedList<>();
        while (!q.isEmpty()) {
            isPenalty = false;
            zombie now = q.poll();


            if(range > now.locate){
                if ((range-penalty+1) * damage < now.health + (range-now.locate) * damage) {
                    if(boom == 0){
                        System.out.println("NO");
                        return;
                    }
                    else{
                        boom--;
                        penalty++;
                        isPenalty = true;
                        p.add(1);
                    }
                }
            }
            else{
                if ((range-penalty) * damage < now.health) {
                    if(boom == 0){
                        System.out.println("NO");
                        return;
                    }
                    else{
                        boom--;
                        penalty++;
                        isPenalty = true;
                        p.add(1);
                    }
                }
            }
            while(true){
                if(p.size() < range) break;
                if(p.poll() == 1) penalty--;
            }

            if(!isPenalty){
                p.add(0);
            }



        }
        System.out.println("YES");
    }
}