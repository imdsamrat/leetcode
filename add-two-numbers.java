/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode s1 = l1, s2 = l2;
        int c = 0;
        ListNode ans = new ListNode(0);
        ListNode start = ans;
        while(s1 != null || s2 != null) {
            int a = (s1 != null) ? s1.val : 0;
            int b = (s2 != null) ? s2.val : 0;
            int sum = a + b + c;
            start.next = new ListNode(sum % 10);
            start = start.next;
            c = sum/10;
            if(s1 != null) s1 = s1.next;
            if(s2 != null) s2 = s2.next;
        }
        if(c != 0)
            start.next = new ListNode(c);
        return ans.next;
    }
}