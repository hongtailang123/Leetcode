class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
	# Don't forget to add self
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1
