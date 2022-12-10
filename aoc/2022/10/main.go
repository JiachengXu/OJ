package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/10/input")
	// lines, err := utils.GetInputLines("2022/10/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	cycles := []int{20, 60, 100, 140, 180, 220}
	val := []int{1, 1, 1, 1, 1, 1}
	num := 0
	res := 0
	for _, line := range lines {
		s := strings.Split(line, " ")
		if s[0] == "noop" {
			num++
		} else if s[0] == "addx" {
			num += 2
			n := utils.Int(s[1])
			for i := 0; i < len(val); i++ {
				if cycles[i] > num {
					val[i] += n
				}
			}
		}
	}
	for i := 0; i < len(val); i++ {
		res += cycles[i] * val[i]
		fmt.Println(val[i])
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	num := 0
	mid := 1
	screen := [6][40]string{}
	for _, line := range lines {
		draw(num, mid, &screen)
		s := strings.Split(line, " ")
		if s[0] == "noop" {
			num++
		} else if s[0] == "addx" {
			num++
			draw(num, mid, &screen)
			num++
			mid += utils.Int((s[1]))
		}
	}
	for i := 0; i < len(screen); i++ {
		fmt.Println(screen[i])
	}
}

func draw(num int, mid int, screen *[6][40]string) {
	x := num / 40
	y := num % 40
	if y >= mid-1 && y <= mid+1 {
		screen[x][y] = "#"
	} else {
		screen[x][y] = "."
	}
}
