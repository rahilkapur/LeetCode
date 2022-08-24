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
    public void reorderList(ListNode head) {
        if (head.next == null) {
            return;
        }
        //find two halves
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null; //new tail of the list, will be pointing to null
        ListNode prev = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        //Merge the halves
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode firstTemp = first.next;
            ListNode secondTemp = second.next;
            first.next = second;
            second.next = firstTemp;
            first = firstTemp;
            second = secondTemp;
        }
        
       
        
    }
}