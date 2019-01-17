class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] res = new int[amount + 1];
        res[0] = 0;
        
        Arrays.sort(coins);
        
        for (int i = 1; i <= amount; i++){
            res[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length && coins[j] <= i; j++){
                if (res[i - coins[j]] != Integer.MAX_VALUE){
                    res[i] = Math.min(res[i - coins[j]] + 1, res[i]);
                }
            }
        }
        
        if (res[amount] == Integer.MAX_VALUE){
            return -1;
        }
        else{
            return res[amount];
        }
    }
}
