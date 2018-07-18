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
            for (int i = 0; i <= element.size(); i++){
                List<Integer> newElement = new ArrayList<Integer>(element);
                newElement.add(i, nums[element.size()]);
                dfs(res, newElement, nums);
            }
        }
    }
}
