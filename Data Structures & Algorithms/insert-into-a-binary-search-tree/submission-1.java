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
 
// class Solution {
//     public TreeNode insertIntoBST(TreeNode root, int val) {
//         if(root == null) {
//             root = new TreeNode(val);
//             return root;
//         }

//         // find the position and insert
//         TreeNode currNode = root;
//         while(currNode != null) {

//             // Left Subtree
//             if(val < currNode.val) {
//                 if(currNode.left == null) {
//                     currNode.left = new TreeNode(val);
//                     break;
//                 }else {
//                     currNode = currNode.left;
//                 }
//             }

//             // Right Subtree
//             else { // val > temp.val
//                 if(currNode.right == null) {
//                     currNode.right = new TreeNode(val);
//                     break;
//                 }else {
//                     currNode = currNode.right;
//                 }
//             }
//         }

//         return root;
//     }
// }

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            root = new TreeNode(val);
            return root;
        }

        if(val < root.val) {
            root.left = insertIntoBST(root.left, val);
        }
        else {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}