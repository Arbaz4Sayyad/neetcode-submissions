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
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> output = new ArrayList<>();
//         postOrder(root, output);
//         return output;
//     }

//     public void postOrder(TreeNode node, List<Integer> output){
//         if(node == null){
//             return;
//         }

//         postOrder(node.left, output);

//         postOrder(node.right, output);
        
//         output.add(node.val);
//     }
// }

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        if(root == null) {
            return output;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while(node != null || !stack.isEmpty()) {
            // move to the left
            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            // move to the right
            if(stack.peek().right != null) {
                node = stack.peek().right;
            } else {
                TreeNode tempNode = stack.pop();
                output.add(tempNode.val);

                while(!stack.isEmpty() && tempNode == stack.peek().right) {
                    tempNode = stack.pop();
                    output.add(tempNode.val);
                }
            }
        }
        return output;
    }
}