package utils

import (
	"io/ioutil"
	"log"
	"strconv"
	"strings"
)

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
