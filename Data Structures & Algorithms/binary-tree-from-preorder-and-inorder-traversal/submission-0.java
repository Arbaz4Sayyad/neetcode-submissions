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
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         Map<Integer, Integer> indexMap = new HashMap<>();
//         // hash the values with index
//         for(int i = 0; i < inorder.length; i++) {
//             indexMap.put(inorder[i], i);
//         }
//         int n = preorder.length - 1;
//         int m = inorder.length - 1;
//         TreeNode root = constructTree(preorder, inorder, indexMap, 0, n, 0, m);

//         return root;
//     }

//     public TreeNode constructTree (int[] preorder, int[] inorder, Map<Integer, Integer> indexMap,
//             int preIndStart, int preIndEnd, int inIndStart, int inIndEnd) {

//         // handle the base cases
//         if(preIndStart > preIndEnd || inIndStart > inIndEnd) {
//             return null;
//         }

//         int rootData = preorder[preIndStart];
//         int rootIndex = indexMap.get(rootData);

//         TreeNode root = new TreeNode(rootData);

//         int leftTreeSize = rootIndex - inIndStart; // rootIndex - 1 - inIndStart + 1;
//         int rightTreeSize = inIndEnd - rootIndex; // inIndEnd - 1 - (rootIndex + 1); 

//         root.left = constructTree(preorder, inorder, indexMap, preIndStart + 1, preIndStart + leftTreeSize, inIndStart, rootIndex - 1);   
//         root.right = constructTree(preorder, inorder, indexMap, preIndStart + leftTreeSize + 1, preIndStart + leftTreeSize + rightTreeSize, rootIndex + 1, inIndEnd);

//         return root;
//     }
// }



class Solution {

    // Keeps track of current root in preorder
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Store inorder value -> index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1, map);
    }

    // Build tree using only inorder boundaries
    private TreeNode build(int[] preorder, int inStart, int inEnd,
                           Map<Integer, Integer> map) {

        // No nodes left
        if (inStart > inEnd) {
            return null;
        }

        // Current preorder element is the root
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = map.get(rootValue);

        // Build left subtree
        root.left = build(preorder, inStart, rootIndex - 1, map);

        // Build right subtree
        root.right = build(preorder, rootIndex + 1, inEnd, map);

        return root;
    }
}