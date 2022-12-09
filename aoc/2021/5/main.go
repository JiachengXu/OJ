package main

import (
	"fmt"
	"log"
	"strconv"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2021/5/input")
	// lines, err := utils.GetInputLines("2021/5/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	a := [1000][1000]int{}
	for _, line := range lines {
		points := strings.Split(line, " -> ")
		p1s := strings.Split(points[0], ",")
		p2s := strings.Split(points[1], ",")

		p1x, err := strconv.Atoi(p1s[0])
		if err != nil {
			log.Fatal(err)
		}
		p1y, err := strconv.Atoi(p1s[1])
		if err != nil {
			log.Fatal(err)
		}
		p2x, err := strconv.Atoi(p2s[0])
		if err != nil {
			log.Fatal(err)
		}
		p2y, err := strconv.Atoi(p2s[1])
		if err != nil {
			log.Fatal(err)
		}
		if p1x != p2x && p1y != p2y {
			continue
		}
		for i := p1x; i <= p2x; i++ {
			for j := p1y; j <= p2y; j++ {
				a[j][i]++
			}
		}
		for i := p2x; i <= p1x; i++ {
			for j := p2y; j <= p1y; j++ {
				a[j][i]++
			}
		}
	}
	res := 0
	for i := 0; i < len(a); i++ {
		for j := 0; j < len(a[0]); j++ {
			if a[i][j] >= 2 {
				res++
			}
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	a := [1000][1000]int{}
	for _, line := range lines {
		points := strings.Split(line, " -> ")
		p1s := strings.Split(points[0], ",")
		p2s := strings.Split(points[1], ",")

		p1x, err := strconv.Atoi(p1s[0])
		if err != nil {
			log.Fatal(err)
		}
		p1y, err := strconv.Atoi(p1s[1])
		if err != nil {
			log.Fatal(err)
		}
		p2x, err := strconv.Atoi(p2s[0])
		if err != nil {
			log.Fatal(err)
		}
		p2y, err := strconv.Atoi(p2s[1])
		if err != nil {
			log.Fatal(err)
		}
		fmt.Printf("(%d, %d) -> (%d, %d)\n", p1y, p1x, p2x, p2y)
		if p1x == p2x || p1y == p2y {
			for i := p1x; i <= p2x; i++ {
				for j := p1y; j <= p2y; j++ {
					a[j][i]++
					fmt.Printf("(%d, %d)\n", j, i)
				}
			}
			for i := p2x; i <= p1x; i++ {
				for j := p2y; j <= p1y; j++ {
					a[j][i]++
					fmt.Printf("(%d, %d)\n", j, i)
				}
			}
		} else if p1y-p2y == p1x-p2x {
			if p1x < p2x {
				for j := p1y; j <= p2y; j++ {
					a[j][p1x+j-p1y]++
					fmt.Printf("(%d, %d)\n", j, j)
				}
			} else {
				for j := p2y; j <= p1y; j++ {
					a[j][p2x+j-p2y]++
					fmt.Printf("(%d, %d)\n", j, j)
				}
			}

		} else if p1y-p2y == -(p1x - p2x) {
			if p1x < p2x {
				for i := p1x; i <= p2x; i++ {
					a[p1y-i+p1x][i]++
					fmt.Printf("(%d, %d)\n", p2x-i+p1x, i)
				}
			} else {
				for i := p2x; i <= p1x; i++ {
					a[p2y-i+p2x][i]++
					fmt.Printf("(%d, %d)\n", p1x-i+p2x, i)
				}
			}
		}
	}
	res := 0
	for i := 0; i < len(a); i++ {
		for j := 0; j < len(a[0]); j++ {
			if a[i][j] >= 2 {
				res++
			}
		}
	}
	fmt.Println(res)
}
