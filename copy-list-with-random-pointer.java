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
        // copy and insert node
        Node start = head;
        while(start != null) {
            Node newNode = new Node(start.val);
            newNode.next = start.next;
            start.next = newNode;
            start = newNode.next;
        }
        
        // assign random pointer
        start = head;
        while(start != null) {
            Node node = start.next;
            if(start.random != null) 
                node.random = start.random.next;
            start = node.next;
        }
        
        // detach and construct copy list 
        start = head;
        Node newList = new Node(0);
        Node start2 = newList;
        while(start != null) {
            Node node = start.next;
            start.next = node.next;
            start = start.next;
            start2.next = node;
            start2 = start2.next;
        }
        return newList.next;
    }
}