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
  public int kthSmallest(TreeNode root, int k) {
    List<Integer> sorted = inorderSort(root);
    System.out.println(sorted);
    return sorted.get(k - 1);
  }

  private List<Integer> inorderSort(TreeNode root) {

    List<Integer> sorted = new ArrayList<>();

    if (root == null) {
      return List.of();
    }

    List<Integer> left = inorderSort(root.left);
    sorted.addAll(left);

    sorted.add(root.val);
    List<Integer> right = inorderSort(root.right);
    sorted.addAll(right);

    return sorted;
  }

}
