package main

import (
	"fmt"
	"log"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/1/input")
	// lines, err := utils.GetInputLines("2022/1/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	nums := utils.GetNumbersWithEmpty(lines)
	res := 0
	car := 0
	for i, n := range nums {
		car += n
		if n == 0 || i == len(nums)-1 {
			if car > res {
				res = car
			}
			car = 0
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	nums := utils.GetNumbersWithEmpty(lines)
	car := 0
	t1 := 0
	t2 := 0
	t3 := 0
	for i, n := range nums {
		car += n
		if n == 0 || i == len(nums)-1 {
			if car > t1 {
				t1, t2, t3 = car, t1, t2
			} else if car > t2 {
				t2, t3 = car, t2
			} else if car > t3 {
				t3 = car
			}
			car = 0
		}
	}
	fmt.Println(t1 + t2 + t3)
}
