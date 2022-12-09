package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

var (
	score = map[string]int{
		"X": 1,
		"Y": 2,
		"Z": 3,
	}
	ops = map[string]string{
		"X": "A",
		"Y": "B",
		"Z": "C",
	}
	comb = map[string]int{
		"A X": 3,
		"A Y": 4,
		"A Z": 8,
		"B X": 1,
		"B Y": 5,
		"B Z": 9,
		"C X": 2,
		"C Y": 6,
		"C Z": 7,
	}
)

func main() {
	lines, err := utils.GetInputLines("2022/2/input")
	// lines, err := utils.GetInputLines("2022/2/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	res := 0
	for _, line := range lines {
		ss := strings.Split(line, " ")
		res += score[ss[1]]
		if ss[0] == "A" && ops[ss[1]] == "C" {
			res += 0
		} else if ss[0] == "C" && ops[ss[1]] == "A" {
			res += 6
		} else if ss[0] < ops[ss[1]] {
			res += 6
		} else if ss[0] == ops[ss[1]] {
			res += 3
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	res := 0
	for _, line := range lines {
		res += comb[line]
	}
	fmt.Println(res)
}
