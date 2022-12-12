package main

import (
	"fmt"
	"log"
	"math"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	m := [][]int{}
	start := []int{}
	end := []int{}
	lines, err := utils.GetInputLines("2022/12/input")
	// lines, err := utils.GetInputLines("2022/12/small")
	if err != nil {
		log.Fatal(err)
	}
	for i := 0; i < len(lines); i++ {
		l := make([]int, len(lines[i]))
		for j := 0; j < len(lines[i]); j++ {
			if lines[i][j] == 'S' {
				l[j] = int('a' - 'a')
				start = []int{i, j, 0}
			} else if lines[i][j] == 'E' {
				l[j] = int('z' - 'a')
				end = []int{i, j}
			} else {
				l[j] = int(lines[i][j] - 'a')
			}
		}
		m = append(m, l)
	}
	solve1(m, start, end)
	solve2(m, end)
}

func solve1(m [][]int, start, end []int) {
	fmt.Println(bfs(m, start, end))
}

func solve2(m [][]int, end []int) {
	res := math.MaxInt
	for i := 0; i < len(m); i++ {
		for j := 0; j < len(m[i]); j++ {
			if m[i][j] != 0 {
				continue
			}
			cur := bfs(m, []int{i, j, 0}, end)
			if cur < res && cur >= 0 {
				res = cur
			}
		}
	}
	fmt.Println(res)
}

func bfs(m [][]int, start, end []int) int {
	queue := [][]int{
		start,
	}
	visited := make([][]bool, len(m))
	for i := range visited {
		visited[i] = make([]bool, len(m[0]))
	}
	for len(queue) > 0 {
		cur := queue[0]
		x, y := cur[0], cur[1]
		queue = queue[1:]
		if visited[x][y] {
			continue
		}
		visited[x][y] = true
		if x == end[0] && y == end[1] {
			return cur[2]
		}
		dirs := [][]int{
			{0, 1},
			{1, 0},
			{-1, 0},
			{0, -1},
		}
		for _, dir := range dirs {
			newx, newy := x+dir[0], y+dir[1]
			if newx < 0 || newx > len(m)-1 || newy < 0 || newy > len(m[0])-1 || visited[newx][newy] {
				continue
			}
			if m[newx][newy]-m[x][y] <= 1 {
				queue = append(queue, []int{newx, newy, cur[2] + 1})
			}
		}
	}
	return -1
}
