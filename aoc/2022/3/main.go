package main

import (
	"fmt"
	"log"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/3/input")
	// lines, err := utils.GetInputLines("2022/3/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	res := 0
	for _, line := range lines {
		l := len(line)
		s1 := line[:l/2]
		s2 := line[l/2:]
	loop:
		for i := 0; i < l/2; i++ {
			for j := 0; j < l/2; j++ {
				if s1[i] == s2[j] {
					score := int(s1[i] - 'a' + 1)
					if score <= 26 && score >= 1 {
						res += score
					} else {
						res += int(s1[i]-'A') + 27
					}
					break loop
				}
			}
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	res := 0
	for i := 0; i < len(lines)-2; i += 3 {
		s1 := lines[i]
		s2 := lines[i+1]
		s3 := lines[i+2]
	loop:
		for i := 0; i < len(s1); i++ {
			for j := 0; j < len(s2); j++ {
				for k := 0; k < len(s3); k++ {
					if s1[i] == s2[j] && s1[i] == s3[k] {
						score := int(s1[i] - 'a' + 1)
						if score <= 26 && score >= 1 {
							res += score
						} else {
							res += int(s1[i]-'A') + 27
						}
						break loop
					}
				}
			}
		}
	}
	fmt.Println(res)
}
