class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode cur = fakeHead;
        int carry = 0;
        int value = 0;
        int value1 = 0;
        int value2 = 0;
        while (l1 != null || l2 != null){
            if (l1 != null){
                value1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                value2 = l2.val;
                l2 = l2.next;
            }
            value = carry + value1 + value2;
            carry = value / 10;
            value = value % 10;
            ListNode newNode = new ListNode(value);
            cur.next = newNode;
            cur = newNode;
            value1 = 0;
            value2 = 0;
        }
        
        // check the special case
        if (carry == 1){
            cur.next = new ListNode(1);
        }
        return fakeHead.next;
    }
}
