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

    int pos = 0;

    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = inOrderTraversal(root, k);

        if(node == null) {
            return -1;
        }

        return node.val;
    }

    // Helper function to store BST values in sorted order
    private TreeNode inOrderTraversal(TreeNode root, int k) {
        
        if (root == null) {
            return root;
        }
        
        TreeNode left = inOrderTraversal(root.left, k);
        if(left != null) {
            return left;
        }

        pos++;
        
        // current node is the target (kth smallest)
        if(pos == k) {
            return root;
        }
       
        TreeNode right = inOrderTraversal(root.right, k);
        if(right != null) {
            return right;
        }

        return null;

        // return inOrderTraversal(root.right, k);
    }
}
