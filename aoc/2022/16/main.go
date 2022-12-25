package main

import (
	"fmt"
	"log"
	"strings"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/16/input")
	// lines, err := utils.GetInputLines("2022/16/small")
	if err != nil {
		log.Fatal(err)
	}
	num := 0
	points := map[string]int{}
	edges := map[string][]string{}
	rates := map[string]int{}
	for _, line := range lines {
		start := ""
		rate := 0
		fmt.Sscanf(line, "Valve %s has flow rate=%d; tunnels lead to valve", &start, &rate)
		ends := strings.Split(strings.TrimPrefix(strings.Split(line, "valve")[1], "s "), ", ")
		if _, ok := points[start]; !ok {
			points[start] = num
			num++
			edges[start] = []string{}
			rates[start] = rate
		}
		for _, end := range ends {
			edges[start] = append(edges[start], strings.TrimSpace(end))
		}
	}
	solve1(points, rates, edges)
	solve2(points, rates, edges)
}

func solve1(points map[string]int, rates map[string]int, edges map[string][]string) {
	space := transversal(30, points, rates, edges)
	res := 0
	for _, v := range space {
		if v > res {
			res = v
		}
	}
	fmt.Println(res)
}

func solve2(points map[string]int, rates map[string]int, edges map[string][]string) {
	space := transversal(26, points, rates, edges)
	m := map[int]int{}
	for k, v := range space {
		max, ok := m[k.opened]
		if !ok || max < v {
			m[k.opened] = v
		}
	}

	res := 0
	for k, v := range m {
		for k2, v2 := range m {
			if k&k2 == 0 && v+v2 > res {
				res = v + v2
			}
		}
	}
	fmt.Println(res)
}

type state struct {
	point  string
	opened int
	time   int
}

type pressureState struct {
	state
	pressure int
}

func transversal(time int, points map[string]int, rates map[string]int, edges map[string][]string) map[state]int {
	space := map[state]int{}
	queue := []pressureState{
		{
			state: state{
				point:  "AA",
				opened: 0,
				time:   time,
			},
			pressure: 0,
		},
	}
	for len(queue) > 0 {
		cur := queue[0]
		queue = queue[1:]
		best, ok := space[cur.state]
		if ok && best >= cur.pressure {
			continue
		}
		space[cur.state] = cur.pressure
		if cur.time < 1 {
			continue
		}
		for _, edge := range edges[cur.point] {
			queue = append(queue, pressureState{
				state: state{
					point:  edge,
					opened: cur.opened,
					time:   cur.time - 1,
				},
				pressure: cur.pressure,
			})
		}
		if cur.opened&(1<<points[cur.point]) == 0 && rates[cur.point] != 0 {
			cur.opened |= (1 << points[cur.point])
			cur.time--
			cur.pressure += cur.time * rates[cur.point]
			queue = append(queue, pressureState{
				state: state{
					point:  cur.point,
					opened: cur.opened,
					time:   cur.time,
				},
				pressure: cur.pressure,
			})
		}
	}
	return space
}
