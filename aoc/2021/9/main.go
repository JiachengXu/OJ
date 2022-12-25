package main

import (
	"fmt"
	"log"
	"sort"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2021/9/input")
	// lines, err := utils.GetInputLines("2021/9/small")
	if err != nil {
		log.Fatal(err)
	}
	m := utils.GetMatrix(lines, "")
	solve1(m)
	solve2(m)
}

func solve1(m [][]int) {
	res := 0
	lowPoints := getLowPoints(m)
	for _, p := range lowPoints {
		res += m[p[0]][p[1]] + 1
	}
	fmt.Println(res)
}

func solve2(m [][]int) {
	lowPoints := getLowPoints(m)
	size := make([]int, len(lowPoints))
	visited := make([][]bool, len(m))
	for i := range visited {
		visited[i] = make([]bool, len(m[i]))
	}
	for i, p := range lowPoints {
		size[i] = dfs(p[0], p[1], m, visited)
	}
	sort.Ints(size)
	fmt.Println(size[len(size)-1] * size[len(size)-2] * size[len(size)-3])
}

func dfs(x, y int, m [][]int, visited [][]bool) int {
	res := 0
	if !visited[x][y] && m[x][y] != 9 {
		visited[x][y] = true
		res++
		utils.Transversal(x, y, m, nil, func(newX, newY int) {
			res += dfs(newX, newY, m, visited)
		})
	}
	return res
}

func getLowPoints(m [][]int) [][]int {
	res := [][]int{}
	for i := 0; i < len(m); i++ {
		for j := 0; j < len(m[i]); j++ {
			lowest := true
			utils.Transversal(i, j, m, nil, func(newX, newY int) {
				if m[i][j] >= m[newX][newY] {
					lowest = false
				}
			})
			if lowest {
				res = append(res, []int{i, j})
			}
		}
	}
	return res
}
