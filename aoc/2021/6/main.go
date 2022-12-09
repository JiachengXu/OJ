package main

import (
	"fmt"
	"log"
	"strconv"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2021/6/input")
	// lines, err := utils.GetInputLines("2021/6/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	input := strings.Split(strings.TrimSpace(lines[0]), ",")
	a := []int{}
	for _, in := range input {
		t, err := strconv.Atoi(in)
		if err != nil {
			log.Fatal(err)
		}
		a = append(a, t)
	}

	for i := 0; i < 80; i++ {
		l := len(a)
		for j := 0; j < l; j++ {
			if a[j] == 0 {
				a[j] = 6
				a = append(a, 8)
			} else {
				a[j]--
			}
		}
	}
	fmt.Println(len(a))
}

func solve2(lines []string) {
	input := strings.Split(strings.TrimSpace(lines[0]), ",")
	m := [9]int{}
	for _, in := range input {
		t, err := strconv.Atoi(in)
		if err != nil {
			log.Fatal(err)
		}
		m[t]++
	}

	for i := 0; i < 256; i++ {
		b := m
		for k := len(m) - 1; k >= 0; k-- {
			v := m[k]
			if k == 0 {
				b[6] += v
				b[8] += v
			} else {
				b[k-1] += v
			}
			b[k] -= v
		}
		m = b
	}
	var res int64 = 0
	for _, v := range m {
		res += int64(v)
	}
	fmt.Println(res)
}
