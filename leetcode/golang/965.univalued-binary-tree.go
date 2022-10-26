/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func isUnivalTree(root *TreeNode) bool {
	m := map[int]struct{}{}
	travel(root, m)
	return len(m) == 1
}

func travel(root *TreeNode, m map[int]struct{}) {
	m[root.Val] = struct{}{}
	if root.Left != nil {
		travel(root.Left, m)
	}
	if root.Right != nil {
		travel(root.Right, m)
	}
}