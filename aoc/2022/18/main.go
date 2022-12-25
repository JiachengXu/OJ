package main

import (
	"fmt"
	"log"
	"math"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/18/input")
	// lines, err := utils.GetInputLines("2022/18/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	points := utils.GetMatrix(lines, ",")
	total := len(points) * 6
	for i := 0; i < len(points); i++ {
		for j := i; j < len(points); j++ {
			if isConnected(points[i], points[j]) {
				total -= 2
			}
		}
	}
	fmt.Println(total)
}

func solve2(lines []string) {
	points := utils.GetMatrix(lines, ",")
	max := make([]int, 3)
	for i := 0; i < 3; i++ {
		max[i] = math.MinInt
	}
	for _, p := range points {
		for i := 0; i < 3; i++ {
			max[i] = utils.Max(max[i], p[i])
		}
	}
	cube := make([][][]int, max[0]+3)
	for i := 0; i < len(cube); i++ {
		cube[i] = make([][]int, max[1]+3)
		for j := 0; j < len(cube[i]); j++ {
			cube[i][j] = make([]int, max[2]+3)
		}
	}
	for _, p := range points {
		cube[p[0]+1][p[1]+1][p[2]+1] = 2
	}
	queue := [][]int{{0, 0, 0}}
	res := 0
	for len(queue) > 0 {
		cur := queue[0]
		queue = queue[1:]
		utils.Transversal3D(cur[0], cur[1], cur[2], cube, nil, func(newX, newY, newZ int) {
			if cube[newX][newY][newZ] == 2 {
				res++
			} else if cube[newX][newY][newZ] == 0 {
				cube[newX][newY][newZ] = 1
				queue = append(queue, []int{newX, newY, newZ})
			}
		})
	}
	fmt.Println(res)
}

func isConnected(a, b []int) bool {
	ax, ay, az := a[0], a[1], a[2]
	bx, by, bz := b[0], b[1], b[2]
	return (ax == bx && ay == by && utils.Abs(az-bz) == 1) ||
		(ay == by && az == bz && utils.Abs(ax-bx) == 1) ||
		(az == bz && ax == bx && utils.Abs(ay-by) == 1)
}
