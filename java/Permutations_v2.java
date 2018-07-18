class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> element = new ArrayList<Integer>();
        dfs(res, element, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> element, int[] nums){
        if (element.size() == nums.length){
            List<Integer> newElement = new ArrayList<Integer>(element);
            res.add(newElement);
            return;
        }
        else{
            for (int i = 0; i < nums.length; i++){
                if (element.contains(nums[i])){
                    continue;
                }
                element.add(nums[i]);
                List<Integer> newElement = new ArrayList<Integer>(element);
                dfs(res, newElement, nums);
                element.remove(element.size() - 1);
            }
        }
    }
}
