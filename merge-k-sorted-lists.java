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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for(ListNode node : lists) {
            if(node != null)
                pq.add(node);
        }
        ListNode ans = new ListNode();
        ListNode start = ans;
        while(!pq.isEmpty()) {
            ListNode temp = pq.poll();
            if(temp.next != null)
                pq.add(temp.next);
            start.next = temp;
            start = start.next;
        }
        return ans.next;
    }
    
}