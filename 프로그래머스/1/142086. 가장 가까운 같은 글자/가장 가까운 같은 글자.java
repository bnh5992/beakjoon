class Solution {
    public int[] solution(String s) {
        char[] bet = new char[26];
        int[] having = new int[26];
        int[] answer = new int[s.length()];
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            boolean isGet = false;
            char now = s.charAt(i);
            int stay = 0;
            for(int j = 0; j < count; j++){
                if(bet[j] == now){
                    isGet = true;
                    stay = j;
                    break;
                }
            }
            
            if(isGet){
                answer[i] = i - having[stay];
                having[stay] = i;
            }
            else{
                answer[i] = -1;
                bet[count] = now;
                having[count] = i;
                count++;
            }
            
            
            
        }
        
        return answer;
    }
}