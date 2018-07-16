class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        fakeHead = ListNode(-1)
        cur = fakeHead
        while l1 is not None or l2 is not None:
            if l1 is None:
                cur.next = l2
                break
            elif l2 is None:
                cur.next = l1
                break
            else:
                if l1.val < l2.val:
                    cur.next = l1
                    l1 = l1.next
                else:
                    cur.next = l2
                    l2 = l2.next
                cur = cur.next
        return fakeHead.next
