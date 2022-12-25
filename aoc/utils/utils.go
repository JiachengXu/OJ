package utils

import (
	"io/ioutil"
	"log"
	"math"
	"strconv"
	"strings"
)

var (
	Dirs = [][]int{
		{0, 1},
		{0, -1},
		{1, 0},
		{-1, 0},
	}
	Dirs3D = [][]int{
		{0, 1, 0},
		{0, -1, 0},
		{1, 0, 0},
		{-1, 0, 0},
		{0, 0, 1},
		{0, 0, -1},
	}
	Dias = [][]int{
		{0, 1},
		{0, -1},
		{1, 0},
		{-1, 0},
		{1, -1},
		{-1, -1},
		{1, 1},
		{-1, 1},
	}
)

func Transversal[T any](x, y int, m [][]T, dirs [][]int, f func(newX, newY int)) {
	if dirs == nil {
		dirs = Dirs
	}
	for _, d := range dirs {
		newX := x + d[0]
		newY := y + d[1]
		if In(newX, newY, m) {
			f(newX, newY)
		}
	}
}

func In[T any](x, y int, m [][]T) bool {
	return x >= 0 && x < len(m) && y >= 0 && y < len(m[x])
}

func Transversal3D[T any](x, y, z int, m [][][]T, dirs [][]int, f func(newX, newY, newZ int)) {
	if dirs == nil {
		dirs = Dirs3D
	}
	for _, d := range dirs {
		newX := x + d[0]
		newY := y + d[1]
		newZ := z + d[2]
		if In3D(newX, newY, newZ, m) {
			f(newX, newY, newZ)
		}
	}
}

func In3D[T any](x, y, z int, m [][][]T) bool {
	return x >= 0 && x < len(m) && y >= 0 && y < len(m[x]) && z >= 0 && z < len(m[x][y])
}

func Reverse(s string) string {
	rns := []rune(s)
	for i, j := 0, len(rns)-1; i < j; i, j = i+1, j-1 {
		rns[i], rns[j] = rns[j], rns[i]
	}
	return string(rns)
}

func GetInputLines(fileName string) ([]string, error) {
	fileContent, err := ioutil.ReadFile(fileName)
	if err != nil {
		return nil, err
	}
	return strings.Split(strings.TrimSpace(string(fileContent)), "\n"), nil
}

func GetMatrixStrs(lines []string, sep string) [][]string {
	metrix := [][]string{}
	for _, line := range lines {
		metrix = append(metrix, strings.Split(line, sep))
	}
	return metrix
}

func GetNumbers(lines []string) []int {
	nums := []int{}
	for _, line := range lines {
		n, err := strconv.Atoi(strings.TrimSpace(line))
		if err != nil {
			log.Fatal(err)
		}
		nums = append(nums, n)
	}
	return nums
}

func GetNumbersWithEmpty(lines []string) []int {
	nums := []int{}
	for _, line := range lines {
		if line == "" {
			nums = append(nums, 0)
			continue
		}
		n, err := strconv.Atoi(strings.TrimSpace(line))
		if err != nil {
			log.Fatal(err)
		}
		nums = append(nums, n)
	}
	return nums
}

func GetMatrix(lines []string, sep string) [][]int {
	metrix := [][]int{}
	for _, line := range lines {
		row := []int{}
		ts := strings.Split(line, sep)
		for _, t := range ts {
			n, err := strconv.Atoi(t)
			if err != nil {
				log.Fatal(err)
			}
			row = append(row, n)
		}
		metrix = append(metrix, row)
	}
	return metrix
}

func Int(s string) int {
	i, _ := strconv.Atoi(s)
	return i
}

func String(i int) string {
	return strconv.Itoa(i)
}

func Abs(a int) int {
	if a >= 0 {
		return a
	}
	return -a
}

func Max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func Min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func SliceMax(a []int) int {
	max := math.MinInt
	for _, k := range a {
		if k > max {
			max = k
		}
	}
	return max
}

func Intersection[T comparable](a, b []T) []T {
	m := map[T]struct{}{}
	for _, v := range a {
		m[v] = struct{}{}
	}

	res := []T{}
	for _, v := range b {
		if _, ok := m[v]; ok {
			res = append(res, v)
		}
	}
	return res
}

func IntersectionStr(a, b, sep string) string {
	return strings.Join(Intersection(strings.Split(a, sep), strings.Split(b, sep)), sep)
}

type Point struct {
	X, Y int
}

func NewPoint(x, y int) Point {
	return Point{
		X: x,
		Y: y,
	}
}

func ManhattanDistance(p1, p2 Point) int {
	return Abs(p1.X-p2.X) + Abs(p1.Y-p2.Y)
}
