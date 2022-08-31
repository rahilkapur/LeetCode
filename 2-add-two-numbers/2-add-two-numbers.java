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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //traverse both lists and add each nodes values and carry to new node
        ListNode p = l1;
        ListNode q = l2;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            node.next = new ListNode(sum % 10);
            node = node.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
            
        }
        //in case carry is still there
        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return dummy.next;
        
    }
}