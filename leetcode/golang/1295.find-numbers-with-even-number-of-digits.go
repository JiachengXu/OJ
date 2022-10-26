func findNumbers(nums []int) int {
	res := 0
	for _, num := range nums {
		dig := getDigitNum(num)
		if dig%2 == 0 {
			res++
		}
	}
	return res
}

func getDigitNum(num int) int {
	res := 0
	for num != 0 {
		num = num / 10
		res++
	}
	return res
}