class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> element = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res, element, nums, used);
        return res;
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> element, int[] nums, boolean[] used){
        if (element.size() == nums.length){
            List<Integer> newElement = new ArrayList<Integer>(element);
            res.add(newElement);
            return;
        }
        else{
            for (int i = 0; i < nums.length; i++){
                if (used[i] || (i != 0 && nums[i] == nums[i - 1] && !used[i - 1])){
                    continue;
                }
                else{
                    used[i] = true;
                    element.add(nums[i]);
                    List<Integer> newElement = new ArrayList<Integer>(element);
                    dfs(res, newElement, nums, used);
                    element.remove(element.size() - 1);
                    used[i] = false;
                }
            }
        }
    }
}
