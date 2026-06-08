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
    // public TreeNode invertTree(TreeNode root) {
    //     if(root == null){
    //         return null;
    //     }
    //     // We will apply dfs here 
    //     TreeNode left = invertTree(root.left);
    //     TreeNode right = invertTree(root.right);

    //     // after applying dfs then we will swap
    //     root.left = right;
    //     root.right = left;

    //     return root;
    // }

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i=0; i<level; i++){
                TreeNode currNode = queue.poll();
                TreeNode temp = currNode.left;
                currNode.left = currNode.right;
                currNode.right = temp;

                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
        }
        return root;
    }
}

