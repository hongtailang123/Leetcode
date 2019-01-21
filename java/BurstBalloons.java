class Solution {
    public int maxCoins(int[] nums) {
        
        int length = nums.length;
        int[] newNums = new int[length + 2];
        newNums[0] = 1;
        newNums[length + 1] = 1;
        for (int i = 0; i < length; i++){
            newNums[i + 1] = nums[i];
        }
                        
        int[][] res = new int[length + 2][length + 2];
        
        for (int k = 2; k < length + 2; k++){
            for (int left = 0; left < length + 2 - k; left++){
                int right = k + left;
                for (int i = left + 1; i < right; i++){
                    res[left][right] = Math.max(res[left][right], newNums[i] * newNums[left] * newNums[right] + res[left][i] + res[i][right]);
                }
            }
        }
        // (0, length + 1), does not include 0 and length + 1
        return res[0][length + 1];
    }
}
