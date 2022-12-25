package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

type Shape struct {
	points [][]int
}

func (s Shape) copy() Shape {
	shape := Shape{}
	points := make([][]int, len(s.points))
	for i := range points {
		points[i] = make([]int, len(s.points[i]))
		copy(points[i], s.points[i])
	}
	shape.points = points
	return shape
}

func (s Shape) move(dir []int) {
	for _, p := range s.points {
		for i := 0; i < len(dir); i++ {
			p[i] += dir[i]
		}
	}
}

func (s Shape) init(bottom []int) {
	highest := 0
	for _, b := range bottom {
		if highest < b {
			highest = b
		}
	}
	dir := []int{highest + 4, 0}
	s.move(dir)
}

func (s Shape) fall() {
	dir := []int{-1, 0}
	s.move(dir)
}

func (s Shape) moveRight(bottom []int) {
	if s.isTouchedRight(bottom) {
		return
	}
	dir := []int{0, 1}
	s.move(dir)
}

func (s Shape) moveLeft(bottom []int) {
	if s.isTouchedLeft(bottom) {
		return
	}
	dir := []int{0, -1}
	s.move(dir)
}

func (s Shape) isTouchedLeft(bottom []int) bool {
	for _, p := range s.points {
		if p[1] == 0 {
			return true
		} else if bottom[p[1]-1] >= p[0] {
			return true
		}
	}
	return false
}

func (s Shape) isTouchedRight(bottom []int) bool {
	for _, p := range s.points {
		if p[1] == 6 {
			return true
		} else if bottom[p[1]+1] >= p[0] {
			return true
		}
	}
	return false
}

func (s Shape) isTouchedBottom(bottom []int) bool {
	for i, b := range bottom {
		for _, p := range s.points {
			if b+1 == p[0] && i == p[1] {
				return true
			}
		}
	}
	return false
}

func (s Shape) updateBottom(bottom []int) []int {
	if !s.isTouchedBottom(bottom) {
		return bottom
	}
	newBottom := make([]int, len(bottom))
	for i := 0; i < len(bottom); i++ {
		b := bottom[i]
		for _, p := range s.points {
			if i == p[1] {
				b = utils.Max(b, p[0])
			}
		}
		newBottom[i] = b
	}
	return newBottom
}

var (
	shapes = []Shape{
		{
			points: [][]int{{0, 2}, {0, 3}, {0, 4}, {0, 5}},
		},
		{
			points: [][]int{{0, 3}, {1, 2}, {1, 3}, {1, 4}, {2, 3}},
		},
		{
			points: [][]int{{0, 2}, {0, 3}, {0, 4}, {1, 4}, {2, 4}},
		},
		{
			points: [][]int{{0, 2}, {1, 2}, {2, 2}, {3, 2}},
		},
		{
			points: [][]int{{0, 2}, {0, 3}, {1, 2}, {1, 3}},
		},
	}
)

func main() {
	lines, err := utils.GetInputLines("2022/17/input")
	// lines, err := utils.GetInputLines("2022/17/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	moves := utils.GetMatrixStrs(lines, "")[0]
	bottom := []int{0, 0, 0, 0, 0, 0, 0}
	rockNum := 2022
	i := 0
	m := 0
	g := make([][]string, 3269)
	for i := range g {
		g[i] = make([]string, 7)
		for j := 0; j < len(g[i]); j++ {
			g[i][j] = "."
		}
	}
	for i < rockNum {
		rock := shapes[i%5].copy()
		rock.init(bottom)
		for {
			move := moves[m%len(moves)]
			if move == ">" {
				rock.moveRight(bottom)
			} else {
				rock.moveLeft(bottom)
			}
			m++
			if rock.isTouchedBottom(bottom) {
				bottom = rock.updateBottom(bottom)
				for _, r := range rock.points {
					g[r[0]][r[1]] = "#"
				}
				break
			}
			rock.fall()
		}
		i++
	}
	for i := len(g) - 1; i >= 0; i-- {
		fmt.Printf("|%s|\n", strings.Join(g[i], ""))
	}
	fmt.Println(utils.SliceMax(bottom))
}

func solve2(lines []string) {
}
