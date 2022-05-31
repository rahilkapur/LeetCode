/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode ptr = head;
        if (head == null || head.next == null) {
            return false;
        }
        ListNode ptr2 = head;
        while (ptr2 != null && ptr2.next != null) {
            ptr = ptr.next;
            ptr2 = ptr2.next.next;
            if (ptr == ptr2) {
                return true;
            }
        }
        return false;
        
    }
}