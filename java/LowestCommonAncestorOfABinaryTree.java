class Solution {
    
    class ResultType{
        TreeNode node;
        boolean hasP;
        boolean hasQ;
        public ResultType(TreeNode node, boolean hasP, boolean hasQ){
            this.node = node;
            this.hasP = hasP;
            this.hasQ = hasQ;
        }
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ResultType result = lca(root, p, q);
        if (result.hasP && result.hasQ){
            return result.node;
        }
        else{
            return null;
        }
    }
    
    private ResultType lca(TreeNode root, TreeNode p, TreeNode q){
        if (root == null){
            return new ResultType(null, false, false);
        }
        
        ResultType l = lca(root.left, p, q);
        ResultType r = lca(root.right, p, q);
        
        boolean hasP = l.hasP || r.hasP || root == p;
        boolean hasQ = l.hasQ || r.hasQ || root == q;
        
        if (root == p || root == q){
            return new ResultType(root, hasP, hasQ);
        }
        else if (l.node != null && r.node != null){
            return new ResultType(root, hasP, hasQ);
        }
        else if (l.node != null){
            return new ResultType(l.node, hasP, hasQ);
        }
        else if (r.node != null){
            return new ResultType(r.node, hasP, hasQ);
        }
        else{
            return new ResultType(null, false, false);
        }
    }
}
