package main

import (
	"fmt"
	"log"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/6/input")
	// lines, err := utils.GetInputLines("2022/6/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	s := lines[0]
	for i := 0; i <= len(s)-4; i++ {
		if !(s[i] == s[i+1] || s[i] == s[i+2] || s[i] == s[i+3] || s[i+1] == s[i+2] || s[i+1] == s[i+3] || s[i+2] == s[i+3]) {
			fmt.Println(i + 4)
			break
		}
	}
}

func solve2(lines []string) {
	s := lines[0]
	for i := 0; i <= len(s)-4; i++ {
		if !(s[i] == s[i+1] || s[i] == s[i+2] || s[i] == s[i+3] || s[i+1] == s[i+2] || s[i+1] == s[i+3] || s[i+2] == s[i+3]) {
			break
		}
	}

	for i := 0; i <= len(s)-14; i++ {
		m := map[byte]bool{}
		for j := i; j <= i+13; j++ {
			m[s[j]] = true
		}
		if len(m) == 14 {
			fmt.Println(i + 14)
			break
		}
	}
}
