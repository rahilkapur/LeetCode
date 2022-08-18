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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            ++size;
        }
        int rem = size - n;
        int ptr = 0; //when ptr == rem remove that node
        temp = head;
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        while (temp != null) {
            if (ptr == rem) {
                prev.next = temp.next;
                temp.next = null;
                break;
                
            }
            else {
                temp = temp.next;
                prev = prev.next;
                ++ptr;
            }
        }
        return dummy.next;
        
        
    }
}