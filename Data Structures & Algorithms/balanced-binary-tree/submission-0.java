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
    static record NodeResult(int depth, boolean isbalanced) {}

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        NodeResult leftResult = root.left != null ? isBalanced(root.left, 1) : new NodeResult(0, true);
        NodeResult rightResult =
            root.right != null ? isBalanced(root.right, 1) : new NodeResult(0, true);
    
        if (!leftResult.isbalanced || !rightResult.isbalanced) {
            return false;
        }
        if (Math.abs(leftResult.depth - rightResult.depth) > 1) {
            return false;
        }
        return true;
  }

  private static NodeResult isBalanced(TreeNode node, int depth) {
        NodeResult leftResult =
            node.left != null ? isBalanced(node.left, depth + 1) : new NodeResult(depth, true);
        NodeResult rightResult =
            node.right != null ? isBalanced(node.right, depth + 1) : new NodeResult(depth, true);
    
        int maxDepth = leftResult.depth > rightResult.depth ? leftResult.depth : rightResult.depth;
        boolean isMaxDepthBalanced = Math.abs(leftResult.depth - rightResult.depth) <= 1;
        boolean areSubtreesBalanced = leftResult.isbalanced && rightResult.isbalanced;
        return new NodeResult(maxDepth, isMaxDepthBalanced && areSubtreesBalanced);
  }

}
