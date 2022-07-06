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
        return isValidCheck(null, null, root);
    }
    public boolean isValidCheck(Integer low, Integer high, TreeNode node) {
        if (node == null) {
            return true;
        }
        if ((low != null && low >= node.val) || (high != null && high <= node.val)) {
            return false;
        }
            return isValidCheck(node.val, high, node.right) && isValidCheck(low, node.val, node.left);
        
    }
}