/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {

//     // Stores the Lowest Common Ancestor once found
//     TreeNode ans = null;

//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

//         // Traverse the tree and determine the LCA
//         helper(root, p, q);

//         // Return the LCA node
//         return ans;
//     }

//     /**
//      * Returns:
//      * 0 -> neither p nor q found in this subtree
//      * 1 -> either p or q found in this subtree
//      * 2 -> both p and q found in this subtree
//      */
//     public int helper(TreeNode node, TreeNode p, TreeNode q) {

//         // Base case: empty subtree
//         if (node == null) {
//             return 0;
//         }

//         // Search left subtree
//         int left = helper(node.left, p, q);

//         // Search right subtree
//         int right = helper(node.right, p, q);

//         // Check if current node is p or q
//         int self = 0;
//         if (node == p || node == q) {
//             self = 1;
//         }

//         // Total targets found in current subtree
//         int total = left + self + right;

//         /*
//          * If total becomes 2 for the first time,
//          * current node is the Lowest Common Ancestor.
//          */
//         if (total == 2 && ans == null) {
//             ans = node;
//         }

//         // Return count of targets found in this subtree
//         return total;
//     }
// }


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // p and q found in different subtrees
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side found a node
        return left != null ? left : right;
    }
}