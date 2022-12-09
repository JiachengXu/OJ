package main

import (
	"fmt"
	"log"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/8/input")
	// lines, err := utils.GetInputLines("2022/8/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	trees := utils.GetMatrix(lines, "")

	res := 0
	for i := 0; i < len(trees); i++ {
		for j := 0; j < len(trees[0]); j++ {
			tree := trees[i][j]
			up := true
			down := true
			right := true
			left := true
			if i == 0 || i == len(trees)-1 || j == 0 || j == len(trees[0])-1 {
				res++
				continue
			}

			for k := 0; k < i; k++ {
				if tree <= trees[k][j] {
					left = false
				}
			}
			for k := i + 1; k < len(trees); k++ {
				if tree <= trees[k][j] {
					right = false
				}
			}
			for k := 0; k < j; k++ {
				if tree <= trees[i][k] {
					up = false
				}
			}
			for k := j + 1; k < len(trees[0]); k++ {
				if tree <= trees[i][k] {
					down = false
				}
			}
			if up || down || left || right {
				res++
			}
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	trees := utils.GetMatrix(lines, "")

	res := 0
	for i := 0; i < len(trees); i++ {
		for j := 0; j < len(trees[0]); j++ {
			tree := trees[i][j]
			up := 0
			down := 0
			right := 0
			left := 0
			if i == 0 || i == len(trees)-1 || j == 0 || j == len(trees[0])-1 {
				continue
			}

			for k := i - 1; k >= 0; k-- {
				up++
				if tree <= trees[k][j] {
					break
				}
			}
			for k := i + 1; k < len(trees); k++ {
				down++
				if tree <= trees[k][j] {
					break
				}
			}
			for k := j - 1; k >= 0; k-- {
				left++
				if tree <= trees[i][k] {
					break
				}
			}
			for k := j + 1; k < len(trees[0]); k++ {
				right++
				if tree <= trees[i][k] {
					break
				}
			}

			cur := up * down * left * right
			if cur > res {
				res = cur
			}
		}
	}
	fmt.Println(res)
}
