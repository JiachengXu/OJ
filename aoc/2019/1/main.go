package main

import (
	"fmt"
	"log"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2019/1/input")
	// lines, err := utils.GetInputLines("2019/1/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	nums := utils.GetNumbers(lines)
	res := 0
	for _, n := range nums {
		res += n/3 - 2
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	nums := utils.GetNumbers(lines)
	res := 0
	for _, n := range nums {
		for n/3-2 > 0 {
			n = n/3 - 2
			res += n
		}
	}
	fmt.Println(res)
}
