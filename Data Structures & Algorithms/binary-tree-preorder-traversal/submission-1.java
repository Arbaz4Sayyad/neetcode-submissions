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
//     public List<Integer> preorderTraversal(TreeNode root) {
//         List<Integer> output = new ArrayList<>();
//         preOrder(root, output);
//         return output;
//     }
//     public void preOrder(TreeNode node, List<Integer> output){
//         if(node == null){
//             return;
//         }

//         output.add(node.val);

//         preOrder(node.left, output);

//         preOrder(node.right, output);
//     }
// }


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if(root == null) {
            return output;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            output.add(currNode.val);

            if(currNode.right != null) {
                stack.push(currNode.right);
            }

            if(currNode.left != null) {
                stack.push(currNode.left);
            }
        }
        
        return output;
    }
}