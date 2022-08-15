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
        ListNode dummy = new ListNode(0 , head);
        ListNode groupBefore = dummy;
        while (true) {
            ListNode kthNode = getKthNode(groupBefore, k);
            if (kthNode == null) { //gone thru whole ll
                break;
            }
            ListNode groupAfter = kthNode.next;
            ListNode prev = groupAfter;
            ListNode curr = groupBefore.next;
            while (curr != groupAfter) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode tmp = groupBefore.next;
            groupBefore.next = kthNode;
            groupBefore = tmp;
        }
        return dummy.next;
        
        
    }
    public ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k -=1;
        }
        return curr;
}
}