func findMaxConsecutiveOnes(nums []int) int {
	res := 0
	length := 0
	for _, num := range nums {
		if num == 1 {
			length++
		} else {
			res = max(res, length)
			length = 0
		}
	}
	res = max(res, length)
	return res

}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
