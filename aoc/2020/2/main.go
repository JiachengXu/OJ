package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2020/2/input")
	// lines, err := utils.GetInputLines("2020/2/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	res := 0
	for _, line := range lines {
		ss := strings.Fields(line)
		r := strings.Split(ss[0], "-")
		l := utils.Int(r[0])
		u := utils.Int(r[1])
		m := 0
		for _, v := range ss[2] {
			if byte(v) == ss[1][0] {
				m++
			}
		}
		if m >= l && m <= u {
			res++
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	res := 0
	for _, line := range lines {
		ss := strings.Fields(line)
		r := strings.Split(ss[0], "-")
		l := utils.Int(r[0])
		u := utils.Int(r[1])
		if (ss[2][l-1] == ss[1][0] && ss[2][u-1] != ss[1][0]) || (ss[2][l-1] != ss[1][0] && ss[2][u-1] == ss[1][0]) {
			res++

		}
	}
	fmt.Println(res)
}
