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
            if (kthNode == null) {
                break;
            }
            ListNode groupAfter = kthNode.next;
            ListNode prev = groupAfter;
            ListNode curr = groupPrev.next;
            while (curr != groupAfter) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = kthNode;
            groupPrev = tmp;
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