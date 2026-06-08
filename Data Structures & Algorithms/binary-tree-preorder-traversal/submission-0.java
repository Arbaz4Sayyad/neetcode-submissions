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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        preOrder(root, output);
        return output;
    }
    public void preOrder(TreeNode node, List<Integer> output){
        if(node == null){
            return;
        }

        output.add(node.val);

        preOrder(node.left, output);

        preOrder(node.right, output);
    }
}