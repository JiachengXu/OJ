package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/4/input")
	// lines, err := utils.GetInputLines("2022/4/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	res := 0
	for _, line := range lines {
		p := strings.Split(line, ",")
		p1 := p[0]
		p2 := p[1]
		p1s := strings.Split(p1, "-")
		p2s := strings.Split(p2, "-")
		p1l := utils.Int(p1s[0])
		p1r := utils.Int(p1s[1])
		p2l := utils.Int(p2s[0])
		p2r := utils.Int(p2s[1])

		if (p1l <= p2l && p1r >= p2r) || (p1l >= p2l && p1r <= p2r) {
			res += 1
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	res := 0
	for _, line := range lines {
		p := strings.Split(line, ",")
		p1 := p[0]
		p2 := p[1]
		p1s := strings.Split(p1, "-")
		p2s := strings.Split(p2, "-")
		p1l := utils.Int(p1s[0])
		p1r := utils.Int(p1s[1])
		p2l := utils.Int(p2s[0])
		p2r := utils.Int(p2s[1])

		if (p1r >= p2l) && (p2r >= p1l) {
			res += 1
		}
	}
	fmt.Println(res)
}
