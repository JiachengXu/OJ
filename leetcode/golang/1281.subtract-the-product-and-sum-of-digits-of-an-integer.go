func subtractProductAndSum(n int) int {
	digits := []int{}
	m := n
	for m > 0 {
		digits = append(digits, m%10)
		m = m / 10
	}

	p := 1
	s := 0
	for _, v := range digits {
		p = p * v
		s = s + v
	}
	return p - s
}