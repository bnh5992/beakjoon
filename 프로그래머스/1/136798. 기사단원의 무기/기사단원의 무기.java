import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int[] powers = new int[number+1];
        ArrayList<Integer> array = getsosu();
        for(int i = 1; i <= number; i++){
            powers[i] = getPower(i, array);
        }
        Arrays.sort(powers);
        for(int i = powers.length-1; i>= 0; i--){
            if(powers[i] > limit){
                powers[i] = power;
                continue;
            }
            break;
        }
        int sum = 0;
        for(int i = 0; i < powers.length; i++){
            sum = sum + powers[i];
        }
        
        return sum;
    }
    
    public int getPower(int num, ArrayList<Integer> array){
        
        ArrayList<Integer> a2 = new ArrayList<>();
        for(int i = 0; i < array.size(); i++){
            if(num == 1 || num == 0) break;
            int count = 0;
            while(num % array.get(i) == 0){
                count++;
                num = num / array.get(i);
                
                
            }
            if(count == 0) continue;
            a2.add(count+1);
            
        }
        int result = 1;
        for(int i = 0; i < a2.size(); i++){
            result = result * a2.get(i);
        }
        
        return result;
    }
    
    public ArrayList<Integer> getsosu(){
        ArrayList<Integer> array = new ArrayList<>();
        boolean[] nums = new boolean[100000];
        nums[1] = true;
        for(int i = 2; i < nums.length; i++){
            for(int j = i+i; j < nums.length; j = j + i){
                nums[j] = true;
            }
        }
        
        for(int i = 1; i < nums.length; i++){
            if(!nums[i]){
                array.add(i);
            }
        }
        return array;
    }
}