package main

import (
	"fmt"
	"log"
	"sort"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2021/10/input")
	// lines, err := utils.GetInputLines("2021/10/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	scores := map[string]int{
		")": 3,
		"]": 57,
		"}": 1197,
		">": 25137,
	}
	pairs := map[string]string{
		")": "(",
		"]": "[",
		"}": "{",
		">": "<",
	}
	nums := map[string]int{
		")": 0,
		"]": 0,
		"}": 0,
		">": 0,
	}
	chunks := utils.GetMatrixStrs(lines, "")
	for _, chunk := range chunks {
		queue := []string{}
		for _, c := range chunk {
			if c == "(" || c == "[" || c == "{" || c == "<" {
				queue = append(queue, c)
				continue
			}
			cur := queue[len(queue)-1]
			if cur == pairs[c] {
				queue = queue[:len(queue)-1]
			} else {
				nums[c]++
				break
			}
		}
	}
	res := 0
	for k, v := range nums {
		res += scores[k] * v
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	scores := map[string]int{
		"(": 1,
		"[": 2,
		"{": 3,
		"<": 4,
	}
	pairs := map[string]string{
		")": "(",
		"]": "[",
		"}": "{",
		">": "<",
	}
	res := []int{}
	chunks := utils.GetMatrixStrs(lines, "")
	for _, chunk := range chunks {
		queue := []string{}
		isCorrupted := false
		for _, c := range chunk {
			if c == "(" || c == "[" || c == "{" || c == "<" {
				queue = append(queue, c)
				continue
			}
			cur := queue[len(queue)-1]
			if cur == pairs[c] {
				queue = queue[:len(queue)-1]
			} else {
				isCorrupted = true
				break
			}
		}
		if isCorrupted {
			continue
		}
		total := 0
		for i := len(queue) - 1; i >= 0; i-- {
			total = total*5 + scores[queue[i]]
		}
		res = append(res, total)
	}
	sort.Ints(res)
	fmt.Println(res[len(res)/2])
}
