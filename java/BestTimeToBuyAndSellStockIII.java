class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        
        int length = prices.length;
        
        int res = 0;
        int min = prices[0];
        int max = prices[length - 1];
        int[] left = new int[length];
        int[] right = new int[length];
        
        for (int i = 1; i < length; i++){
            min = Math.min(min, prices[i]);
            left[i] = Math.max(left[i - 1], prices[i] - min);
        }
        
        for (int i = length - 1; i >= 1; i--){
            max = Math.max(max, prices[i]);
            right[i - 1] = Math.max(right[i], max - prices[i - 1]);
        }
        
        for (int i = 0; i < length; i++){
            res = Math.max(res, left[i] + right[i]);
        }
        
        return res;
    }
}
