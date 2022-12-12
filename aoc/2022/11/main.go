package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/11/input")
	// lines, err := utils.GetInputLines("2022/11/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	items := [][]int{}
	ops := [][]string{}
	tests := [][]int{}
	for i := 0; i < len(lines)-5; i += 7 {
		items = append(items, []int{})
		ops = append(ops, []string{})
		tests = append(tests, []int{})
		num := utils.Int(string(lines[i][len(lines[i])-2]))
		its := strings.Split(strings.Split(lines[i+1], "  Starting items: ")[1], ", ")
		for _, i := range its {
			items[num] = append(items[num], utils.Int(i))
		}
		op := strings.Split(lines[i+2], " ")
		ops[num] = append(ops[num], op[len(op)-3:]...)
		test := strings.Split(lines[i+3], " ")
		tests[num] = append(tests[num], utils.Int(test[len(test)-1]))
		testT := strings.Split(lines[i+4], " ")
		tests[num] = append(tests[num], utils.Int(testT[len(testT)-1]))
		testF := strings.Split(lines[i+5], " ")
		tests[num] = append(tests[num], utils.Int(testF[len(testF)-1]))
	}

	res := [8]int{}
	for j := 0; j < 20; j++ {
		for i := 0; i < len(items); i++ {
			if len(items[i]) == 0 {
				continue
			}
			for _, it := range items[i] {
				worry := it
				num := 0
				if ops[i][2] == "old" {
					num = worry
				} else {
					num = utils.Int(ops[i][2])
				}
				switch ops[i][1] {
				case "+":
					worry += num
				case "-":
					worry -= num
				case "*":
					worry *= num
				case "/":
					worry /= num
				}
				worry /= 3

				if worry%tests[i][0] == 0 {
					items[tests[i][1]] = append(items[tests[i][1]], worry)
				} else {
					items[tests[i][2]] = append(items[tests[i][2]], worry)
				}
				res[i]++
			}
			items[i] = []int{}
		}
	}
	m1 := 0
	m2 := 0
	for _, v := range res {
		if v > m1 {
			m1, m2 = v, m1
		} else if v > m2 {
			m2 = v
		}
	}
	fmt.Println(m1 * m2)
}
func solve2(lines []string) {
	items := [][]int{}
	ops := [][]string{}
	tests := [][]int{}
	lcm := 1
	for i := 0; i < len(lines)-5; i += 7 {
		items = append(items, []int{})
		ops = append(ops, []string{})
		tests = append(tests, []int{})
		num := utils.Int(string(lines[i][len(lines[i])-2]))
		its := strings.Split(strings.Split(lines[i+1], "  Starting items: ")[1], ", ")
		for _, i := range its {
			items[num] = append(items[num], utils.Int(i))
		}
		op := strings.Split(lines[i+2], " ")
		ops[num] = append(ops[num], op[len(op)-3:]...)
		test := strings.Split(lines[i+3], " ")
		tests[num] = append(tests[num], utils.Int(test[len(test)-1]))
		testT := strings.Split(lines[i+4], " ")
		tests[num] = append(tests[num], utils.Int(testT[len(testT)-1]))
		testF := strings.Split(lines[i+5], " ")
		tests[num] = append(tests[num], utils.Int(testF[len(testF)-1]))
		lcm *= tests[num][0]
	}

	res := [8]int{}
	for j := 0; j < 10000; j++ {
		for i := 0; i < len(items); i++ {
			if len(items[i]) == 0 {
				continue
			}
			for _, it := range items[i] {
				worry := it
				num := 0
				if ops[i][2] == "old" {
					num = worry
				} else {
					num = utils.Int(ops[i][2])
				}
				switch ops[i][1] {
				case "+":
					worry += num
				case "-":
					worry -= num
				case "*":
					worry *= num
				case "/":
					worry /= num
				}
				if worry%tests[i][0] == 0 {
					items[tests[i][1]] = append(items[tests[i][1]], worry%lcm)
				} else {
					items[tests[i][2]] = append(items[tests[i][2]], worry%lcm)
				}
				res[i]++
			}
			items[i] = []int{}
		}
	}
	m1 := 0
	m2 := 0
	for _, v := range res {
		if v > m1 {
			m1, m2 = v, m1
		} else if v > m2 {
			m2 = v
		}
	}
	fmt.Println(res)
	fmt.Println(m1 * m2)
}
