func pivotIndex(nums []int) int {
	sum := 0
	for _, v := range nums {
		sum = sum + v
	}
	tmp := 0
	for i, v := range nums {
		if tmp*2+v == sum {
			return i
		}
		tmp = tmp + v
	}
	return -1
}