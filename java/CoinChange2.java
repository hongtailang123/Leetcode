class Solution {
    public int change(int amount, int[] coins) {
        int[] res = new int[amount + 1];
        res[0] = 1;
        // dp[i, j] = dp[i - 1, j] + dp[i, j - coins[i]]
        for (int i = 0; i < coins.length; i++){
            for (int j = coins[i]; j <= amount; j++){
                res[j] = res[j] + res[j - coins[i]];
            }
        }
        
        return res[amount];
    }
}
