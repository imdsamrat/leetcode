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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        int cnt = 0;
        while(start != null){
            start = start.next;
            cnt++;
            if(cnt == k)
                break;
        }
        if(cnt < k)
            return head;
        ListNode curr = head, prev = null, next = null;
        while(curr != start) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = reverseKGroup(start, k);
        if(prev != null)
            return prev;
        return head;
    }
}