class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i = 1; i < food.length; i++){
            int now = food[i] / 2;
            for(int j = 0; j < now; j++){
                answer = answer + String.valueOf(i);
            }
        }
        answer = answer + "0";
        for(int i = food.length-1; i >= 1; i--){
            int now = food[i] / 2;
            for(int j = 0; j < now; j++){
                answer = answer + String.valueOf(i);
            }
        }
        
        return answer;
    }
}