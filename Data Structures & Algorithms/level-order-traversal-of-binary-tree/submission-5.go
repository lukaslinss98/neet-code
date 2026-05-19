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

	queue := Queue{
		queue: []*TreeNode{root},
	}
	result := [][]int{}
	for queue.length() > 0 {

		queueLength := queue.length()
		level := []int{}

		for range queueLength {

			node := queue.dequeue()
			level = append(level, node.Val)

			if node.Left != nil {
				queue.enqueue(node.Left)
			}

			if node.Right != nil {
				queue.enqueue(node.Right)
			}
			
		}
		result = append(result, level)

	}
	return result
}

