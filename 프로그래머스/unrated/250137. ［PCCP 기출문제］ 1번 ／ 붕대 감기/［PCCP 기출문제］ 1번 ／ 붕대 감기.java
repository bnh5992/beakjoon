class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int attLen = 0;
        boolean bandAttack = false;
        int time = 1;
        int bandTime = 0;
        int fullHealth = health;
        
        while(attLen != attacks.length){
            if(health <= 0) return -1;
            
            if(attacks[attLen][0] == time){
                bandTime = 0;
                health = health - attacks[attLen][1];
                attLen++;
                time++;
                continue;
            }
            
            bandTime++;
            if(health + bandage[1] > fullHealth){
                health = fullHealth;
                time++;
                continue;
            }
            if(bandTime == bandage[0]){
                health = health + bandage[2] + bandage[1];
                if(health > fullHealth){
                    health = fullHealth;
                }
                bandTime = 0;
                time++;
                continue;
            }
            health = health + bandage[1];
            time++;
        }
        
        if(health <= 0) return -1;
        return health;
    }
}
