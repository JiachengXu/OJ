func minSubArrayLen(target int, nums []int) int {
	res := len(nums) + 1
	sum := 0
	left := 0
	for i, v := range nums {
		sum += v
		for sum >= target {
			res = min(res, i-left+1)
			sum -= nums[left]
			left++
		}
	}
	if res == len(nums)+1 {
		return 0
	}
	return res
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}