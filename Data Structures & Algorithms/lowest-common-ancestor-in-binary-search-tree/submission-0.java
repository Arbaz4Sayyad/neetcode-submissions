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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while(curr != null){
            // if both the values of p and q are greater than root then search in right
            if(p.val > curr.val && q.val > curr.val){
                curr = curr.right;
            }else if(p.val < curr.val && q.val < curr.val){
                // if both the values of p and q are smaller than root then search in left
                curr = curr.left;
            }else{
                // otherwise return root
                return curr;
            }
        }
        return null;
    }
}
