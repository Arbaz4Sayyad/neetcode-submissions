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

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    // Returns the height of the tree
    public int height(TreeNode root) {

        // Empty tree has height 0
        if (root == null)
            return 0;

        // Height of left subtree
        int left = height(root.left);

        // Height of right subtree
        int right = height(root.right);

        // Diameter passing through current node
        diameter = Math.max(diameter, left + right);

        // Return current node height
        return 1 + Math.max(left, right);
    }
}