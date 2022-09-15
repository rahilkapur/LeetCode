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
                //gone through the whole ist
                break;
            }
            ListNode groupAfter = kthNode.next;
            ListNode bef = groupAfter;
            ListNode curr = groupPrev.next;
            while (curr != groupAfter) {
                ListNode temp = curr.next;
                curr.next = bef;
                bef = curr;
                curr = temp;
            }
            ListNode t = groupPrev.next;
            groupPrev.next = kthNode;
            groupPrev = t;
            
        }
        return dummy.next;
        
    }
    public ListNode getKthNode(ListNode t, int k) {
        while (t != null && k > 0) {
            t = t.next;
            k--;
        }
        return t;
    }
}