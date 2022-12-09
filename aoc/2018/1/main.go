package main

import (
	"fmt"
	"log"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2018/1/input")
	// lines, err := utils.GetInputLines("2018/1/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	res := 0
	nums := utils.GetNumbers(lines)
	for _, n := range nums {
		res += n
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	m := map[int]bool{
		0: true,
	}
	res := 0
	nums := utils.GetNumbers(lines)
	for {
		for _, n := range nums {
			res += n
			if m[res] {
				fmt.Println(res)
				return
			}
			m[res] = true
		}
	}
}
