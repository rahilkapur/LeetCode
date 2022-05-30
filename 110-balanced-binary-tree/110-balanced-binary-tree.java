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
    public boolean isBalanced(TreeNode root) {
        int height = 0;
        if (root == null) {
            return true;
        }
        
        height = dfs(root);
        return height != -1;
    }
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        if (left == -1) {
            return -1;
        }
        int right = dfs(node.right);
         if (right == -1) {
            return -1;
        }
        if ((left + 1) < right) {
            return -1;
        }
        else if ((right + 1) < left) {
            return -1;
        }
        return Math.max(left, right) + 1;
}
}