package main

func dominantIndex(nums []int) int {
	// Find the largest one
	largest := 0
	second := 0
	index := 0
	for i, v := range nums {
		if v > largest {
			largest, second = v, largest
			index = i
		} else if v > second {
			second = v
		}
	}
	if largest >= second*2 {
		return index
	}
	return -1
}
