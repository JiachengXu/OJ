package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

var (
	move = map[string][]int{
		"R": {1, 0},
		"L": {-1, 0},
		"U": {0, 1},
		"D": {0, -1},
	}

	diagonalMove = [][]int{
		{1, -1},
		{1, 1},
		{-1, -1},
		{-1, 1},
	}

	lineMove = [][]int{
		{1, 0},
		{-1, 0},
		{0, -1},
		{0, 1},
	}
)

func main() {
	lines, err := utils.GetInputLines("2022/9/input")
	// lines, err := utils.GetInputLines("/Users/jiachengxu/projects/personal/oj/aoc/2022/9/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	res := map[string]bool{}
	h := []int{0, 0}
	t := []int{0, 0}
	for _, line := range lines {
		ss := strings.Split(line, " ")
		d := ss[0]
		n := utils.Int(ss[1])
		for i := 0; i < n; i++ {
			h[0] += move[d][0]
			h[1] += move[d][1]
			if !isAdjacent(t, h) {
				if needDiagonalMove(t, h) {
					for _, di := range diagonalMove {
						tmp := []int{}
						tmp = append(tmp, t[0]+di[0])
						tmp = append(tmp, t[1]+di[1])
						if isAdjacent(tmp, h) {
							t = tmp
							break
						}
					}
				} else {
					t[0] += move[d][0]
					t[1] += move[d][1]
				}
			}
			cor := fmt.Sprintf("(%d, %d)", t[0], t[1])
			res[cor] = true
		}
	}
	fmt.Println(len(res))
}

func solve2(lines []string) {
	res := map[string]bool{}
	r := [][]int{}
	l := 10
	for i := 0; i < l; i++ {
		r = append(r, []int{0, 0})

	}
	for _, line := range lines {
		ss := strings.Split(line, " ")
		d := ss[0]
		n := utils.Int(ss[1])
		for i := 0; i < n; i++ {
			r[0][0] += move[d][0]
			r[0][1] += move[d][1]
			for j := 0; j < len(r)-1; j++ {
				h := r[j]
				t := r[j+1]
				if !isAdjacent(t, h) {
					if needDiagonalMove(t, h) {
						for _, di := range diagonalMove {
							tmp := []int{}
							tmp = append(tmp, t[0]+di[0])
							tmp = append(tmp, t[1]+di[1])
							if isAdjacent(tmp, h) {
								t = tmp
								break
							}
						}
					} else if needLineMove(t, h) {
						for _, di := range lineMove {
							tmp := []int{}
							tmp = append(tmp, t[0]+di[0])
							tmp = append(tmp, t[1]+di[1])
							if isAdjacent(tmp, h) {
								t = tmp
								break
							}
						}
					} else {
						t[0] += move[d][0]
						t[1] += move[d][1]
					}
				}
				r[j+1] = t
			}
			cor := fmt.Sprintf("(%d, %d)", r[l-1][0], r[l-1][1])
			res[cor] = true
		}
	}
	fmt.Println(len(res))
}

func isAdjacent(t, h []int) bool {
	xt, yt := t[0], t[1]
	xh, yh := h[0], h[1]
	return utils.Abs(xt-xh) <= 1 && utils.Abs(yt-yh) <= 1
}

func needDiagonalMove(t, h []int) bool {
	xt, yt := t[0], t[1]
	xh, yh := h[0], h[1]
	return (utils.Abs(xt-xh) == 2 && utils.Abs(yt-yh) >= 1) || (utils.Abs(xt-xh) >= 1 && utils.Abs(yt-yh) == 2)
}

func needLineMove(t, h []int) bool {
	xt, yt := t[0], t[1]
	xh, yh := h[0], h[1]
	return (utils.Abs(xt-xh) == 2 && utils.Abs(yt-yh) == 0) || (utils.Abs(xt-xh) == 0 && utils.Abs(yt-yh) == 2)
}
