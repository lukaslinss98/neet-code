/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

type Queue struct {
	queue []*TreeNode
}

func (q *Queue) enqueue(el *TreeNode) {
	q.queue = append(q.queue, el)
}

func (q *Queue) dequeue() *TreeNode {
	el := q.queue[0]
	q.queue = q.queue[1:]
	return el
}

func (q *Queue) length() int {
	return len(q.queue)
}

func levelOrder(root *TreeNode) [][]int {

	if root == nil {
		return [][]int{}
	}

	return dfs(root)
}

func dfs(root *TreeNode) [][]int {
	queue := Queue{
		queue: []*TreeNode{root},
	}

	nodeToLevel := map[*TreeNode]int{
		root: 0,
	}

	levelToNodes := [][]int{}

	for queue.length() > 0 {
		node := queue.dequeue()
		level := nodeToLevel[node]

		if len(levelToNodes)-1 < level {
			levelToNodes = append(levelToNodes, []int{node.Val})
		} else {
			levelSlice := levelToNodes[level]
			levelSlice = append(levelSlice, node.Val)
			levelToNodes[level] = levelSlice
		}

		if node.Left != nil {
			queue.enqueue(node.Left)
			nodeToLevel[node.Left] = level + 1
		}
		if node.Right != nil {
			queue.enqueue(node.Right)
			nodeToLevel[node.Right] = level + 1
		}
	}

	return levelToNodes
}
