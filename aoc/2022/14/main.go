package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/14/input")
	// lines, err := utils.GetInputLines("2022/14/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

var cut = 300

func solve1(lines []string) {
	m := buildMap(lines)
	res := 0
	for {
		x := 0
		y := 500 - cut
		for x < len(m)-1 {
			if canGoDown(x, y, m) {
				x++
			} else if canGoDownLeft(x, y, m) {
				x++
				y--
			} else if canGoDownRight(x, y, m) {
				x++
				y++
			} else {
				m[x][y] = "o"
				res++
				for i := 0; i < len(m); i++ {
					fmt.Println(m[i])
				}
				break
			}
		}
		if x == len(m)-1 {
			break
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	m := buildMap(lines)
	maxX := 0
	for i := 0; i < len(m); i++ {
		for j := 0; j < len(m[i]); j++ {
			if m[i][j] == "#" {
				maxX = i
				break
			}
		}
	}
	for i := 0; i < len(m[maxX+2]); i++ {
		m[maxX+2][i] = "#"
	}
	for i := 0; i < len(m); i++ {
		fmt.Println(m[i])
	}
	res := 0
	for {
		x := 0
		y := 500 - cut
		for {
			if canGoDown(x, y, m) {
				x++
			} else if canGoDownLeft(x, y, m) {
				x++
				y--
			} else if canGoDownRight(x, y, m) {
				x++
				y++
			} else {
				m[x][y] = "o"
				res++
				for i := 0; i < len(m); i++ {
					fmt.Println(m[i])
				}
				break
			}
		}
		if x == 0 && y == 500-cut {
			break
		}
	}
	fmt.Println(res)
}

func buildMap(lines []string) [][]string {
	m := make([][]string, 200)
	for i := range m {
		m[i] = make([]string, 400)
		for j := range m[i] {
			m[i][j] = "."
		}
	}
	for _, line := range lines {
		points := strings.Split(line, " -> ")
		ps := [][]int{}
		for _, p := range points {
			cords := strings.Split(p, ",")
			x := utils.Int(cords[1])
			y := utils.Int(cords[0]) - cut
			ps = append(ps, []int{x, y})
		}
		for i := 0; i < len(ps)-1; i++ {
			start := ps[i]
			end := ps[i+1]
			for i := utils.Min(start[0], end[0]); i <= utils.Max(start[0], end[0]); i++ {
				for j := utils.Min(start[1], end[1]); j <= utils.Max(start[1], end[1]); j++ {
					m[i][j] = "#"
				}
			}
		}
		m[0][500-cut] = "+"
	}
	for i := 0; i < len(m); i++ {
		fmt.Println(m[i])
	}
	return m
}

func canGoDown(x, y int, m [][]string) bool {
	return m[x+1][y] != "#" && m[x+1][y] != "o"
}

func canGoDownRight(x, y int, m [][]string) bool {
	return m[x+1][y+1] != "#" && m[x+1][y+1] != "o"
}

func canGoDownLeft(x, y int, m [][]string) bool {
	return m[x+1][y-1] != "#" && m[x+1][y-1] != "o"
}
