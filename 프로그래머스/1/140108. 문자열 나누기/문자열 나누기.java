class Solution {
    public int solution(String s) {
        int answer = 0;
        boolean isFirst = true;
        char start = 'a';
        int[] count = new int[2];
        for(int i = 0; i < s.length(); i++){
            
            if(isFirst){
                start = s.charAt(i);
                isFirst = false;
                count[0]++;
                continue;
            }
            char now = s.charAt(i);
            if(now == start){
                count[0]++;
            }
            else{
                count[1]++;
            }
            
            if(count[0] == count[1]){
                answer++;
                isFirst = true;
                count = new int[2];
                continue;
            }
        }
        if(count[0] + count[1] > 0){
            answer++;
        }
        return answer;
    } 
}