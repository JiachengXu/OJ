package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2021/8/input")
	// lines, err := utils.GetInputLines("2021/8/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	res := 0
	for _, line := range lines {
		outs := strings.Split(strings.Split(line, " | ")[1], " ")
		for _, out := range outs {
			if len(out) == 2 || len(out) == 3 || len(out) == 4 || len(out) == 7 {
				res++
			}
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	res := 0
	for _, line := range lines {
		s := strings.Split(line, " | ")
		inputs := strings.Split(s[0], " ")
		outs := strings.Split(s[1], " ")
		m := decode(inputs)
		tmp := 0
		for _, out := range outs {
			tmp = tmp*10 + getNumber(out, m)
		}
		res += tmp
	}
	fmt.Println(res)
}

func getNumber(signal string, m map[int]string) int {
	for k, v := range m {
		if len(utils.IntersectionStr(signal, v, "")) == len(v) && len(v) == len(signal) {
			return k
		}
	}
	return -1
}

func decode(signals []string) map[int]string {
	m := map[int]string{}
	for _, signal := range signals {
		if len(signal) == 2 {
			m[1] = signal
		}
		if len(signal) == 3 {
			m[7] = signal
		}
		if len(signal) == 4 {
			m[4] = signal
		}
		if len(signal) == 7 {
			m[8] = signal
		}
	}
	signal25 := []string{}
	signal09 := []string{}
	for _, signal := range signals {
		inter17 := utils.IntersectionStr(m[1], m[7], "")
		if len(signal) == 6 {
			if len(utils.IntersectionStr(signal, inter17, "")) == 1 {
				m[6] = signal
			} else {
				signal09 = append(signal09, signal)
			}
		}
		if len(signal) == 5 {
			if len(utils.IntersectionStr(signal, inter17, "")) == 2 {
				m[3] = signal
			} else {
				signal25 = append(signal25, signal)
			}
		}
	}
	inter25 := utils.IntersectionStr(signal25[0], signal25[1], "")
	if len(utils.IntersectionStr(signal09[0], inter25, "")) == 2 {
		m[0] = signal09[0]
		m[9] = signal09[1]
	} else {
		m[0] = signal09[1]
		m[9] = signal09[0]
	}
	if len(utils.IntersectionStr(signal25[0], m[9], "")) == 5 {
		m[5] = signal25[0]
		m[2] = signal25[1]
	} else {
		m[5] = signal25[1]
		m[2] = signal25[0]
	}
	return m
}
