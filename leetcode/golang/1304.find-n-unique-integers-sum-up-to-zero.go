func sumZero(n int) []int {
	res := []int{}
	if n%2 != 0 {
		res = append(res, 0)
	}

	for i := 1; i <= n/2; i++ {
		res = append(res, i, -i)
	}
	return res
}