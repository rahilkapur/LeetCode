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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list1ptr = list1;
        ListNode list2ptr = list2;
        ListNode first;
        ListNode temp;
        if (list1ptr == null && list2ptr == null) {
            return list1ptr;
        }
        else if (list1ptr == null) {
                temp = new ListNode(list2ptr.val);
                first = temp;
                list2ptr = list2ptr.next;
            }
            else if (list2ptr == null) {
                temp = new ListNode(list1ptr.val);
                first = temp;
                list1ptr = list1ptr.next;
            }
        else if (list1ptr.val < list2ptr.val) {
                temp = new ListNode(list1ptr.val);
                first = temp;
                list1ptr = list1ptr.next;
            }
            else {
                temp = new ListNode(list2ptr.val);
                first = temp;
                list2ptr = list2ptr.next;
            }
        while (list1ptr != null && list2ptr != null) {
             if (list1ptr.val <= list2ptr.val) {
                temp.next = new ListNode(list1ptr.val);
                list1ptr = list1ptr.next;
            }
            else {
                 temp.next = new ListNode(list2ptr.val);
                list2ptr = list2ptr.next;
            }
            temp = temp.next;
        }
        if (list1ptr == null) {
            temp.next = list2ptr;
        }
        else {
            temp.next = list1ptr;
        }
        return first;
    }
}