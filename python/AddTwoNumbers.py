class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        
        fakeHead = ListNode(-1);
        cur = fakeHead
        value = 0
        value1 = 0
        value2 = 0
        carry = 0
        while l1 is not None or l2 is not None:
            if l1 is not None:
                value1 = l1.val
                l1 = l1.next
            if l2 is not None:
                value2 = l2.val
                l2 = l2.next
            value = value1 + value2 + carry
            carry = value / 10
            value = value % 10
            newNode = ListNode(value)
            cur.next = newNode
            cur = newNode
            value1 = 0
            value2 = 0
        
        # special case
        if carry == 1:
            cur.next = ListNode(1) 
        
        return fakeHead.next
