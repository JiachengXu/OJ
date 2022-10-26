package main

import "sort"

func trimMean(arr []int) float64 {
	sort.Ints(arr)
	remove := len(arr) / 20
	sum := 0
	for i := remove; i < len(arr)-remove; i++ {
		sum += arr[i]
	}
	return float64(sum) / float64((len(arr) - remove*2))
}
