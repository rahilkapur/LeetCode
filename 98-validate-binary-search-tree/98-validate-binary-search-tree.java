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
    public boolean isValidBST(TreeNode root) {
        return validCheck(root, null, null);
        
    }
    public boolean validCheck(TreeNode node, Integer low, Integer high) {
        if (node == null) {
            return true; //null nodes are valid
        }
        if ((low != null && low >= node.val) || (high != null && node.val >= high)) {
            return false;
        }
        return validCheck(node.right, node.val, high) && validCheck(node.left, low, node.val);
    }
}