/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public ArrayList<Integer> inOrder(TreeNode curr, ArrayList<Integer> list) {
        if (curr == null) { //traversed thru whole bst
            return list;
        }
        inOrder(curr.left, list);
        list.add(curr.val);
        inOrder(curr.right, list);
        return list;
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> li = inOrder(root, new ArrayList<Integer>());
        return li.get(k - 1); //k - 1 will be kth element in list
        
    }
}