class Solution(object):
    def invertTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if root is None:
            return root
        cur = []
        cur.append(root)
        while len(cur) != 0:
            next = []
            for node in cur:
                if node.left is not None:
                    next.append(node.left)
                if node.right is not None:
                    next.append(node.right)
                temp = node.left
                node.left = node.right
                node.right = temp
            cur = next
        return root
