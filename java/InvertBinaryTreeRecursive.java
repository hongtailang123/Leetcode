class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        List<TreeNode> cur = new ArrayList<TreeNode>();
        cur.add(root);
        while (cur.size() != 0){
            List<TreeNode> next = new ArrayList<TreeNode>();
            for (int i = 0; i < cur.size(); i++){
                TreeNode node = cur.get(i);
                if (node.left != null){
                   next.add(node.left); 
                }
                if (node.right != null){
                    next.add(node.right);
                }
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            cur = next;
        }
        return root;
    }
