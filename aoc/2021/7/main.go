package main

import (
	"fmt"
	"log"
	"math"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2021/7/input")
	// lines, err := utils.GetInputLines("2021/7/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	pos := utils.GetMatrix(lines, ",")[0]
	res := math.MaxInt
	for _, p := range pos {
		tmp := 0
		for _, r := range pos {
			tmp += utils.Abs(p - r)
		}
		if tmp < res {
			res = tmp
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	pos := utils.GetMatrix(lines, ",")[0]
	res := math.MaxInt
	min := math.MaxInt
	max := 0
	for _, p := range pos {
		if p > max {
			max = p
		}
		if p < min {
			min = p
		}
	}
	for i := min; i <= max; i++ {
		tmp := 0
		for _, p := range pos {
			tmp += (1 + utils.Abs(p-i)) * (utils.Abs(p - i)) / 2
		}
		if tmp < res {
			res = tmp
		}
	}
	fmt.Println(res)
}
