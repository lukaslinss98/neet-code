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
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) {
      return null;
    }
    int rootVal = preorder[0];

    int rootValInorderIndex = 0;

    while (rootValInorderIndex < inorder.length) {
      if (inorder[rootValInorderIndex] == rootVal) {
        break;
      }
      rootValInorderIndex++;
    }

    int[] leftInorderSlice = Arrays.copyOfRange(inorder, 0, rootValInorderIndex);
    int[] rightInorderSlice = Arrays.copyOfRange(inorder, rootValInorderIndex + 1, inorder.length);

    int[] leftPreorderSlice = Arrays.copyOfRange(preorder, 1, leftInorderSlice.length + 1);
    int[] rightPreorderSlice =
        Arrays.copyOfRange(preorder, preorder.length - rightInorderSlice.length, preorder.length);

    TreeNode left = buildTree(leftPreorderSlice, leftInorderSlice);
    TreeNode right = buildTree(rightPreorderSlice, rightInorderSlice);

    return new TreeNode(rootVal, left, right);
  }
}
