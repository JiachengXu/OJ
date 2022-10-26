package main

import (
	"strconv"
	"strings"
)

func convertTime(c1 string, c2 string) int {
	if c1 == c2 {
		return 0
	}
	cc1 := strings.Split(c1, ":")
	cc2 := strings.Split(c2, ":")
	res := 0
	h1, _ := strconv.Atoi(cc1[0])
	m1, _ := strconv.Atoi(cc1[1])
	h2, _ := strconv.Atoi(cc2[0])
	m2, _ := strconv.Atoi(cc2[1])
	diff := h2*60 + m2 - h1*60 - m1
	ops := []int{60, 15, 5, 1}
	for _, o := range ops {
		res += diff / o
		diff -= o * (diff / o)
	}
	return res
}
