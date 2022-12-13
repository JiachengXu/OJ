package main

import (
	"fmt"
	"log"
	"sort"
	"strconv"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/13/input")
	// lines, err := utils.GetInputLines("2022/13/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	res := 0
	pair := 0
	for i := 0; i < len(lines)-1; i += 3 {
		left := lines[i]
		right := lines[i+1]
		pair++
		if compare(left, right) < 0 {
			res += pair
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	ls := []string{
		"[[2]]",
		"[[6]]",
	}
	for i := 0; i < len(lines); i++ {
		if len(lines[i]) != 0 {
			ls = append(ls, lines[i])
		}
	}
	sort.Sort(Sort(ls))
	id2, id6 := 0, 0
	for i, v := range ls {
		if v == "[[2]]" {
			id2 = i + 1
		}
		if v == "[[6]]" {
			id6 = i + 1
		}
	}
	fmt.Println(id2 * id6)
}

type Sort []string

func (a Sort) Len() int {
	return len(a)
}

func (a Sort) Swap(i, j int) {
	a[i], a[j] = a[j], a[i]
}

func (a Sort) Less(i, j int) bool {
	return compare(a[i], a[j]) < 0
}

func compare(left, right string) int {
	ln, err := strconv.Atoi(left)
	rn, err2 := strconv.Atoi(right)
	if err == nil && err2 == nil {
		return ln - rn
	}
	if err == nil {
		left = "[" + left + "]"
	}
	if err2 == nil {
		right = "[" + right + "]"
	}
	ls := split(left)
	rs := split(right)
	for i := 0; i < len(ls); i++ {
		if i > len(rs)-1 {
			return 1
		}
		tmp := compare(ls[i], rs[i])
		if tmp > 0 {
			return 1
		}
		if tmp < 0 {
			return -1
		}
	}
	if len(ls) < len(rs) {
		return -1
	}
	return 0
}

func split(s string) []string {
	res := []string{}
	news := s[1 : len(s)-1]
	for len(news) > 0 {
		num := 0
		for i := 0; i < len(news); i++ {
			if news[i] == '[' {
				num++
			} else if news[i] == ']' {
				num--
			}
			if num == 0 {
				next := i
				for j := next; j < len(news); j++ {
					if news[j] == ',' {
						next = j
						break
					}
				}
				if next == i {
					next = len(news)
				}
				res = append(res, news[0:next])
				news = strings.TrimPrefix(news[next:], ",")
				break
			}
		}
	}
	return res
}
