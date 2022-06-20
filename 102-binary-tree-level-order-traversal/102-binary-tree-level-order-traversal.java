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
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return ans;
        }
        search(root, 0);
        return ans;
    }
    public void search(TreeNode curr, int level) {
        if (ans.size() == level) { //means that we need to create a new sublist to hold values of current level
            ans.add(new ArrayList<Integer>());
            
        }
        ans.get(level).add(curr.val);
        if (curr.left != null) {
            search(curr.left, level + 1);
        }
        if (curr.right != null) {
             search(curr.right, level + 1);
        }
    }
}