/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node head2 = new Node(1);
        Node start = head;
        
        // copy and put node just next to the node
        while(start != null) {
            Node node = new Node(start.val);
            node.next = start.next;
            start.next = node;
            start = start.next.next;
        }
        
        // update random pointer
        start = head;
        while(start != null) {
            Node node = start.next;
            if(start.random != null)
            node.random = start.random.next;
            start = start.next.next;
        }
        
        // detach the copy list
        start = head;
        Node start2 = head2;
        while(start != null) {
            Node node = start.next;
            start2.next = node;
            start.next = node.next;
            if(node.next != null)
                node.next = node.next.next;
            start = start.next;
            start2 = start2.next;
        }
        return head2.next;
    }
}