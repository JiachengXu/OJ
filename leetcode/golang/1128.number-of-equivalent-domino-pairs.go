func numEquivDominoPairs(dominoes [][]int) int {
	m := map[[2]int]int{}
	for _, v := range dominoes {
		var tmp [2]int
		if v[0] < v[1] {
			tmp[0] = v[0]
			tmp[1] = v[1]
		} else {
			tmp[0] = v[1]
			tmp[1] = v[0]
		}
		m[tmp]++
	}

	res := 0
	for _, v := range m {
		res += v * (v - 1) / 2
	}
	return res
}