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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        while(n-- != 0) {
            start = start.next;
        }
        ListNode start2 = head, prev = null;
        while(start != null) {
            prev = start2;
            start2 = start2.next;
            start = start.next;
        }
        if(prev == null)
            return head.next;
        prev.next = prev.next.next;
        return head;
    }
}