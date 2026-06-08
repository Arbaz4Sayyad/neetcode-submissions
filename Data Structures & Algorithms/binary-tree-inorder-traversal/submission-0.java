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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        inOrder(root, output);
        return output;
    }

    public void inOrder(TreeNode node, List<Integer> output){
        if(node == null){
            return;
        }
        inOrder(node.left, output);
        output.add(node.val);
        inOrder(node.right, output);
    }
}