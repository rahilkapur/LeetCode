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
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        double len = 1;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            ++len;
        }
        double middle =  Math.ceil(len / 2);
        System.out.println(middle);
        double where = 1;
        while (where != middle) {
            head = head.next;
            where++;
        }
        return head;
    }
}