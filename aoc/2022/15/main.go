package main

import (
	"fmt"
	"log"
	"sort"

	"github.com/jiachengxu/oj/aoc/utils"
)

func main() {
	lines, err := utils.GetInputLines("2022/15/input")
	// lines, err := utils.GetInputLines("2022/15/small")
	if err != nil {
		log.Fatal(err)
	}
	solve1(lines)
	solve2(lines)
}

func solve1(lines []string) {
	size := 10000000
	sensors := map[utils.Point]bool{}
	beacons := map[utils.Point]bool{}
	scopes := map[utils.Point]int{}
	for _, line := range lines {
		xs, ys, xb, yb := 0, 0, 0, 0
		fmt.Sscanf(line, "Sensor at x=%d, y=%d: closest beacon is at x=%d, y=%d", &xs, &ys, &xb, &yb)
		sensor := utils.NewPoint(xs, ys)
		beacon := utils.NewPoint(xb, yb)
		sensors[sensor] = true
		beacons[beacon] = true
		scopes[sensor] = utils.ManhattanDistance(sensor, beacon)
	}
	res := 0
	for i := -size * 10; i < size*10; i++ {
		for s := range sensors {
			p := utils.NewPoint(i, 2000000)
			if utils.ManhattanDistance(s, p) <= scopes[s] && !beacons[p] {
				res++
				break
			}
		}
	}
	fmt.Println(res)
}

func solve2(lines []string) {
	size := 4000000
	sensors := map[utils.Point]bool{}
	scopes := map[utils.Point]int{}
	for _, line := range lines {
		xs, ys, xb, yb := 0, 0, 0, 0
		fmt.Sscanf(line, "Sensor at x=%d, y=%d: closest beacon is at x=%d, y=%d", &xs, &ys, &xb, &yb)
		sensor := utils.NewPoint(xs, ys)
		beacon := utils.NewPoint(xb, yb)
		sensors[sensor] = true
		scopes[sensor] = utils.ManhattanDistance(sensor, beacon)
	}
	for i := 0; i <= size; i++ {
		intervals := [][]int{}
		for sensor := range sensors {
			interval := getCoveredInterval(i, size, sensor, scopes[sensor])
			if len(interval) != 0 {
				intervals = append(intervals, interval)
			}
		}
		idx := unDetectedIdx(intervals, size)
		if idx != -1 {
			fmt.Println(idx*4000000 + i)
			return
		}
	}
}

func getCoveredInterval(y, size int, sensor utils.Point, distance int) []int {
	xDist := distance - utils.Abs(sensor.Y-y)
	if xDist < 0 {
		return []int{}
	}
	return []int{utils.Max(0, sensor.X-xDist), utils.Min(size, sensor.X+xDist)}
}

func unDetectedIdx(intervals [][]int, size int) int {
	sort.Slice(intervals, func(i, j int) bool { return intervals[i][0] < intervals[j][0] })
	left := intervals[0][0]
	if left > 0 {
		return 0
	}
	right := intervals[0][1]
	for i := 1; i < len(intervals); i++ {
		if intervals[i][0] > right {
			return right + 1
		}
		right = utils.Max(right, intervals[i][1])
	}
	if right != size {
		return size
	}
	return -1
}
