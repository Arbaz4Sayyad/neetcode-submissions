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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null || subRoot == null){
            return root == subRoot;
        }
        if(root.val == subRoot.val && isSame(root, subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true; // both trees are empty
        }
        if(p == null && q != null || p != null && q == null || p.val != q.val){
            return false; // trees are not same;
        }
        boolean check = true;
        check = (isSame(p.left, q.left) && isSame(p.right, q.right));
        return check;
    }
}