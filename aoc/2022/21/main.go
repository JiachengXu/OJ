package main

import (
	"fmt"
	"log"
	"strconv"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/21/input")
	// lines, err := utils.GetInputLines("2022/21/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	m := map[string]string{}
	res := map[string]int{}
	for _, line := range lines {
		tokens := strings.Split(line, ": ")
		if num, err := strconv.Atoi(tokens[1]); err == nil {
			res[tokens[0]] = num
		}
		m[tokens[0]] = tokens[1]
	}
	fmt.Println(dp("root", m, res))
}

func solve2(lines []string) {
	n1, n2 := "", ""
	m := map[string]string{}
	res := map[string]int{}
	for _, line := range lines {
		tokens := strings.Split(line, ": ")
		if num, err := strconv.Atoi(tokens[1]); err == nil {
			res[tokens[0]] = num
		}
		m[tokens[0]] = tokens[1]
		if tokens[0] == "root" {
			ops := strings.Split(tokens[1], " ")
			n1 = ops[0]
			n2 = ops[2]
		}
	}
	val := 3769668716000
	v1, v2 := 0, 0
	for {
		mcopy := make(map[string]string)
		for k, v := range m {
			mcopy[k] = v
		}
		rescopy := make(map[string]int)
		for k, v := range res {
			rescopy[k] = v
		}
		rescopy["humn"] = val
		mcopy["humn"] = strconv.Itoa(val)
		v1 = dp(n1, mcopy, rescopy)
		// v2 := 40962717833337
		v2 = dp(n2, mcopy, rescopy)
		fmt.Printf("humn: %d, %s: %d, %s: %d, %d\n", val, n1, v1, n2, v2, v1+v2)
		if v1 == v2 {
			break
		}
		val++
	}
	fmt.Println(val)
}

func dp(name string, m map[string]string, res map[string]int) int {
	if num, ok := res[name]; ok {
		return num
	}
	tokens := strings.Split(m[name], " ")
	val := 0
	switch tokens[1] {
	case "+":
		val = dp(tokens[0], m, res) + dp(tokens[2], m, res)
	case "-":
		val = dp(tokens[0], m, res) - dp(tokens[2], m, res)
	case "*":
		val = dp(tokens[0], m, res) * dp(tokens[2], m, res)
	case "/":
		val = dp(tokens[0], m, res) / dp(tokens[2], m, res)
	}
	res[name] = val
	return val
}
