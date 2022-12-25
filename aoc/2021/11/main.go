package main

import (
	"fmt"
	"log"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2021/11/input")
	// lines, err := utils.GetInputLines("2021/11/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	m := utils.GetMatrix(lines, "")
	step := 100
	res := 0
	for i := 0; i < step; i++ {
		increase(m)
		res += flash(m)
		reset(m)
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	m := utils.GetMatrix(lines, "")
	n := len(m) * len(m[0])
	i := 0
	for {
		i++
		increase(m)
		if n == flash(m) {
			fmt.Println(i)
			return
		}
		reset(m)
	}
}

func increase(m [][]int) {
	for j := 0; j < len(m); j++ {
		for k := 0; k < len(m[j]); k++ {
			m[j][k]++
		}
	}
}

func flash(m [][]int) int {
	flashed := make([][]bool, len(m))
	for j := range flashed {
		flashed[j] = make([]bool, len(m[j]))
	}
	prevNum := 0
	for {
		flashNum := 0
		for x := 0; x < len(m); x++ {
			for y := 0; y < len(m[x]); y++ {
				if m[x][y] <= 9 || flashed[x][y] {
					continue
				}
				utils.Transversal(x, y, m, utils.Dias, func(newX, newY int) {
					if !flashed[newX][newY] {
						m[newX][newY]++
					}
				})
				flashed[x][y] = true
			}
		}
		for x := 0; x < len(m); x++ {
			for y := 0; y < len(m[x]); y++ {
				if flashed[x][y] {
					flashNum++
				}
			}
		}
		if prevNum == flashNum {
			break
		}
		prevNum = flashNum
	}
	return prevNum
}

func reset(m [][]int) {
	for x := 0; x < len(m); x++ {
		for y := 0; y < len(m[x]); y++ {
			if m[x][y] > 9 {
				m[x][y] = 0
			}
		}
	}
}
