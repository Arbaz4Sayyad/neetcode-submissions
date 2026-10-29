/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "N";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode currNode = queue.poll();
            if(currNode == null){
                sb.append("N, ");
                continue;
            }
            sb.append(currNode.val).append(", ");
            queue.offer(currNode.left);
            queue.offer(currNode.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("N")) return null;

        String[] values = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0].trim())); // Trim spaces
        queue.offer(root);

        int i = 1; // Start from the second element
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (!values[i].trim().equals("N")) { // Trim before comparison
                node.left = new TreeNode(Integer.parseInt(values[i].trim()));
                queue.offer(node.left);
            }
            i++;

            if (!values[i].trim().equals("N")) {
                node.right = new TreeNode(Integer.parseInt(values[i].trim()));
                queue.offer(node.right);
            }
            i++;
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));