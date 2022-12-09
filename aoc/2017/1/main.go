package main

import (
	"fmt"
	"log"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2017/1/input")
	// lines, err := utils.GetInputLines("2017/1/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	res := 0
	digits := lines[0] + string(lines[0][0])
	for i := 0; i < len(digits)-1; i++ {
		if digits[i] == digits[i+1] {
			res += utils.Int(string(digits[i]))
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	res := 0
	l := len(lines[0])
	digits := lines[0] + string(lines[0][0:l/2])
	for i := 0; i < len(digits)-l/2; i++ {
		if digits[i] == digits[i+l/2] {
			res += utils.Int(string(digits[i]))
		}
	}
	fmt.Println(res)
}
