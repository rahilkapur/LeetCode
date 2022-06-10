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
    private int diameter = Integer.MIN_VALUE; //global var keeping track of diameter
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        dfs(root);
        return diameter;
        
    }
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int rightLen = dfs(node.right); //will get right branch of current node
        int leftLen = dfs(node.left); //will get left branch of current node
        diameter = Math.max(diameter, rightLen + leftLen); //here we update new diameter if current nodes diameter is larger
        return Math.max(rightLen, leftLen) + 1; //then we return this recursively to this nodes parent to add one to signify the longest branch of the node + itself
    }
}