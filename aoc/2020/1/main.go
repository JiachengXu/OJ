package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2020/1/input")
	// lines, err := utils.GetInputLines("2020/1/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	m := map[int]bool{}
	for _, line := range lines {
		n := utils.Int(strings.TrimSpace(line))
		if m[n] {
			fmt.Println(n * (2020 - n))
			break
		}
		m[2020-n] = true
	}
}

func solve2(lines []string) {
	nums := []int{}
	for _, line := range lines {
		n := utils.Int(strings.TrimSpace(line))
		nums = append(nums, n)
	}
	for k, n := range nums {
		t := twoSum(nums[k+1:], 2020-n)
		if t != -1 {
			fmt.Println(n * t)
		}
	}
}

func twoSum(nums []int, sum int) int {
	m := map[int]bool{}
	for _, n := range nums {
		if m[n] {
			return n * (sum - n)
		}
		m[sum-n] = true
	}
	return -1
}
