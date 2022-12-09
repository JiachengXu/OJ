package main

import (
	"fmt"
	"log"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2018/2/input")
	// lines, err := utils.GetInputLines("2018/2/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	two := 0
	three := 0
	for _, line := range lines {
		m := map[rune]int{}
		t2, t3 := 0, 0
		for _, r := range line {
			m[r]++
		}
		for _, v := range m {
			if v == 2 {
				t2 = 1
			} else if v == 3 {
				t3 = 1
			}
		}
		two += t2
		three += t3
	}
	fmt.Println(two * three)
}

func solve2(lines []string) {
	for i := 0; i < len(lines); i++ {
		for j := i + 1; j < len(lines); j++ {
			diff := 0
			pos := -1
			for k := 0; k < len(lines[0]); k++ {
				if lines[i][k] != lines[j][k] {
					diff++
					pos = k
					if diff > 1 {
						break
					}
				}
			}
			if diff == 1 {
				fmt.Println(lines[i][:pos] + lines[i][pos+1:])
				return
			}
		}
	}
}
