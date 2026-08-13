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

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxValue) {

        // Base case
        if (node == null) {
            return 0;
        }

        int count = 0;

        // Check if current node is a good node
        if (node.val >= maxValue) {
            count = 1;
        }

        // Update maximum value seen so far
        maxValue = Math.max(maxValue, node.val);

        // Traverse left and right subtrees
        count += dfs(node.left, maxValue);
        count += dfs(node.right, maxValue);

        return count;
    }
}