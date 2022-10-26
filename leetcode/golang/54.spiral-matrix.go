package main

func spiralOrder(matrix [][]int) []int {
	if len(matrix) == 0 || len(matrix[0]) == 0 {
		return []int{}
	}
	m := len(matrix)
	n := len(matrix[0])
	res := []int{}
	up := 0
	down := m - 1
	left := 0
	right := n - 1
	for up <= down && left <= right {
		for j := left; j <= right; j++ {
			res = append(res, matrix[up][j])
		}
		up++

		for i := up; i <= down; i++ {
			res = append(res, matrix[i][right])
		}
		right--

		if up <= down {
			for j := right; j >= left; j-- {
				res = append(res, matrix[down][j])
			}
		}
		down--

		if left <= right {
			for i := down; i >= up; i-- {
				res = append(res, matrix[i][left])
			}
		}
		left++
	}
	return res
}
