class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0){
            return res;
        }
        List<Integer> element = new ArrayList<Integer>();
        dfs(res, element, candidates, target, 0, 0);
        return res;        
    }
    
    private void dfs(List<List<Integer>> res, List<Integer> element, int[] candidates, int target, int index, int sum){
        if (sum > target){
            return;
        }
        
        if (sum == target){
            List<Integer> newElement = new ArrayList<Integer>(element);
            res.add(newElement);
            return;
        }
        
        for (int i = index; i < candidates.length; i++){
            element.add(candidates[i]);
            List<Integer> newElement = new ArrayList<Integer>(element);
            dfs(res, element, candidates, target, i, sum + candidates[i]);
            element.remove(element.size() - 1);
        }
        
    }
}
