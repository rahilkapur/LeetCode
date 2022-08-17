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
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;
        while (true) {
            ListNode kthNode = getKthNode(groupPrev, k);
            if (kthNode == null) { //reached end of list
                break;                
            }
            ListNode groupAfter = kthNode.next;
            ListNode curr = groupPrev.next;
            ListNode temp = groupAfter;
            while (curr != groupAfter) {
                ListNode tmp = curr.next;
                curr.next = temp;
                temp = curr;
                curr = tmp;
            }
            //make sure previos ones point to correct ones
            ListNode node = groupPrev.next;
            groupPrev.next = kthNode;
            groupPrev = node;
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