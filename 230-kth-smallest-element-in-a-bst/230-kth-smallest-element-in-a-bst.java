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
    public void get(ArrayList<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        //add nodes in order traversal to add in list correctly to get order of values correctly
        get(list, node.left);
        list.add(node.val);
        get(list, node.right);
        
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList();
        get(list, root);
        return list.get(k - 1);
        
    }
}