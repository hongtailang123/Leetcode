class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> pre = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++){
            pre.add(new ArrayList<Integer>());
        }
        
        for (int i= 0; i < prerequisites.length; i++){
            pre.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] taken = new boolean[numCourses];
        List<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i < numCourses; i++){
            if (!dfs(i, visited, taken, pre, res)){
                return new int[0];
            }
        }
        
        int[] resArray = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++){
            resArray[i] = res.get(i);
        }
        
        return resArray;
    }
    
    private boolean dfs(int courseId, boolean[] visited, boolean[] taken, List<List<Integer>> pre, List<Integer> res){
        if (taken[courseId]){
            return true;
        }
        
        if (visited[courseId]){
            return false;
        }
        
        visited[courseId] = true;
        for (int i : pre.get(courseId)){
            if (!dfs(i, visited, taken, pre, res)){
                return false;
            }
        }
        
        visited[courseId] = false;
        taken[courseId] = true;
        res.add(courseId);
        
        return true;       
    }
}
