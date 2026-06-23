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
    // public int maxDepth(TreeNode root) {
    //     if(root == null){
    //         return 0;
    //     }

    //     int left = maxDepth(root.left);
    //     int right = maxDepth(root.right);

    //     return Math.max(left, right) + 1; 
    // }

    // private int answer;

    // public int maxDepth(TreeNode root) {
    //     answer = 0;
    //     maxDepthHelper(root, 1);
    //     return answer;
    // }

    // public void maxDepthHelper(TreeNode node, int depth){
    //     if(node == null){
    //         return;
    //     }

    //     answer = Math.max(answer, depth);
    //     maxDepthHelper(node.left, depth + 1);
    //     maxDepthHelper(node.right, depth + 1);
    // }

    public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int depth = 0;

    while (!queue.isEmpty()) {
        int size = queue.size();  // number of nodes at current level
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        depth++; // completed one level
    }

    return depth;
}
}