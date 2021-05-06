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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ListNode currNode;
    public TreeNode sortedListToBST(ListNode head) {
        currNode = head;
        int n = 0;
        while(head != null) {
            n++;
            head = head.next;
        }
        return buildBST(n);
    }
    
    public TreeNode buildBST(int n) {
        if(n == 0)
            return null;
        TreeNode node = new TreeNode();
        node.left = buildBST(n/2);
        node.val = currNode.val;
        currNode = currNode.next;
        node.right = buildBST(n - n/2 - 1);
        return node;
    }
}