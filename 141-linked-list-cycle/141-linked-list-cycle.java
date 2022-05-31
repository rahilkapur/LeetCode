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
        ListNode curr = head;
        ArrayList<ListNode> values = new ArrayList();
        while (curr != null) {
            if (values.contains(curr) && values.contains(curr)) {
                return true;
            }
            values.add(curr);
            curr = curr.next;
        }
        return false;
        
    }
}