class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        ListNode s1 = l1, s2 = l2, dummyHead = new ListNode();
        ListNode s = dummyHead;
        while(s1 != null && s2 != null){
            if(s1.val <= s2.val){
                s.next = s1;
                s1 = s1.next;
            } else {
                s.next = s2;
                s2 = s2.next;
            }
            s = s.next;
        }
        if(s1 == null)
            s.next = s2;
        if(s2 == null)
            s.next = s1;
        return dummyHead.next;
    }
}