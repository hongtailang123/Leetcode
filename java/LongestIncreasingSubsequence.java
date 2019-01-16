class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length < 1){
            return 0;
        }
        
        int n = nums.length;
        int[] f = new int[n];
        int max = 0;
        
        for (int i = 0; i < n; i++){
            f[i] = 1;
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            max = Math.max(max, f[i]);
        }
        
        return max;
    }
}
