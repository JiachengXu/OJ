package main

import (
	"fmt"
	"log"
	"strconv"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/3/input")
	// lines, err := utils.GetInputLines("2021/3/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	m := [12]int{}
	for _, line := range lines {
		ss := strings.Split(line, "")
		for i := range ss {
			if ss[i] == "1" {
				m[i]++
			}
		}
	}

	gamma := ""
	epsi := ""
	for _, v := range m {
		if v+v > len(lines) {
			gamma += "1"
			epsi += "0"
		} else {
			gamma += "0"
			epsi += "1"
		}
	}
	g, err := strconv.ParseInt(gamma, 2, 64)
	if err != nil {
		log.Fatal(err)
	}
	e, err := strconv.ParseInt(epsi, 2, 64)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(g * e)
}

func solve2(lines []string) {
	ox := ""
	co := ""
	oxx := ""
	coo := ""
	for i := 0; i < 12; i++ {
		n := 0
		m := 0
		nl := 0
		ml := 0
		for _, line := range lines {
			if strings.HasPrefix(line, ox) {
				if strings.Split(line, "")[i] == "1" {
					n++
				}
				nl++
				oxx = line
			}
			if strings.HasPrefix(line, co) {
				if strings.Split(line, "")[i] == "1" {
					m++
				}
				ml++
				coo = line
			}
		}
		if nl == 1 {
			ox = oxx
		} else if n+n >= nl {
			ox += "1"
		} else {
			ox += "0"
		}
		if ml == 1 {
			co = coo
		} else if m+m >= ml {
			co += "0"
		} else {
			co += "1"
		}
	}
	o, err := strconv.ParseInt(ox, 2, 64)
	if err != nil {
		log.Fatal(err)
	}
	c, err := strconv.ParseInt(co, 2, 64)
	if err != nil {
		log.Fatal(err)
	}
	fmt.Println(o * c)
}
