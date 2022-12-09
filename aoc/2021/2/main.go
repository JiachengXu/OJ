package main

import (
	"fmt"
	"log"
	"strconv"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2021/2/input")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	h := 0
	d := 0
	for _, line := range lines {
		ss := strings.Split(line, " ")
		n, _ := strconv.Atoi(ss[1])
		if ss[0] == "forward" {
			h += n
		} else if ss[0] == "down" {
			d += n
		} else if ss[0] == "up" {
			d -= n
		}
	}
	fmt.Println(h * d)
}

func solve2(lines []string) {
	h := 0
	d := 0
	a := 0
	for _, line := range lines {
		ss := strings.Split(line, " ")
		n, _ := strconv.Atoi(ss[1])
		if ss[0] == "forward" {
			h += n
			d += a * n
		} else if ss[0] == "down" {
			a += n
		} else if ss[0] == "up" {
			a -= n
		}
	}
	fmt.Println(h * d)
}
