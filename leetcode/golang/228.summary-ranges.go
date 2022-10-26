package main

import "fmt"

func summaryRanges(nums []int) []string {
	if len(nums) == 0 {
		return []string{}
	}
	var res []string
	start := nums[0]
	for i := 1; i < len(nums); i++ {
		if nums[i] != nums[i-1]+1 {
			if nums[i-1] == start {
				res = append(res, fmt.Sprintf("%d", start))
			} else {
				res = append(res, fmt.Sprintf("%d->%d", start, nums[i-1]))
			}
			start = nums[i]
		}
	}
	if start == nums[len(nums)-1] {
		res = append(res, fmt.Sprintf("%d", start))
	} else {
		res = append(res, fmt.Sprintf("%d->%d", start, nums[len(nums)-1]))
	}
	return res
}
