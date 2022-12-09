package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/5/input")
	// lines, err := utils.GetInputLines("2022/5/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	ss := []string{
		"GJZ",
		"CVFWPRLQ",
		"RGLCMPF",
		"MHPWBFL",
		"QVSFCG",
		"LTQMZJHW",
		"VBSFH",
		"SZJF",
		"TBHFPDCM",
	}
	for _, s := range lines {
		nums := strings.Split(s, " ")
		num := utils.Int(nums[0])
		from := utils.Int(nums[1])
		to := utils.Int(nums[2])
		m := ss[from-1][:num]
		rm := utils.Reverse(m)
		ss[from-1] = ss[from-1][num:]
		ss[to-1] = rm + ss[to-1]
	}
	res := ""
	for _, s := range ss {
		res += string(s[0])
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	ss := []string{
		"GJZ",
		"CVFWPRLQ",
		"RGLCMPF",
		"MHPWBFL",
		"QVSFCG",
		"LTQMZJHW",
		"VBSFH",
		"SZJF",
		"TBHFPDCM",
	}
	for _, s := range lines {
		nums := strings.Split(s, " ")
		num := utils.Int(nums[0])
		from := utils.Int(nums[1])
		to := utils.Int(nums[2])
		rm := ss[from-1][:num]
		ss[from-1] = ss[from-1][num:]
		ss[to-1] = rm + ss[to-1]
	}
	res := ""
	for _, s := range ss {
		res += string(s[0])
	}
	fmt.Println(res)
}
