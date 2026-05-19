/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func hasPathSum(root *TreeNode, targetSum int) bool {
	if root == nil {
		return false
	}

	updatedSum :=  targetSum - root.Val
	if updatedSum == 0 && root.Left == nil && root.Right == nil {
		return true
	}


	if root.Left != nil && hasPathSum(root.Left, updatedSum) {
		return true
	}

	if root.Right != nil && hasPathSum(root.Right, updatedSum) {
		return true
	}


	return false
}

