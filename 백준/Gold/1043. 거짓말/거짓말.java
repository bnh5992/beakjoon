import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int partyNum = Integer.parseInt(st.nextToken());

        boolean[] knowing = new boolean[people+1];
        boolean[] remainParty = new boolean[partyNum];

        Set<Integer>[] array = new Set[partyNum];
        Queue<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        int knowPeopleNum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowPeopleNum; i++) {
            int pKnow = Integer.parseInt(st.nextToken());
            knowing[pKnow] = true;
            q.add(pKnow);
        }

        for (int i = 0; i < partyNum; i++) {
            array[i] = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int pNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < pNum; j++) {
                array[i].add(Integer.valueOf(st.nextToken()));
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            for (int i = 0; i < partyNum; i++) {
                if(array[i].contains(cur) && !remainParty[i]){
                    remainParty[i] = true;
                    List<Integer> a = List.copyOf(array[i]);
                    for (int j = 0; j < array[i].size(); j++) {
                        if(!knowing[a.get(j)]){
                            q.add(a.get(j));
                            knowing[a.get(j)] = true;
                        }

                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < remainParty.length; i++) {
            if(!remainParty[i]){
                result++;
            }
        }

        System.out.println(result);
    }
}