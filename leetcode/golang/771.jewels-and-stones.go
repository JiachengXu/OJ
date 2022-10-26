func numJewelsInStones(J string, S string) int {
	counter := 0
	var low [26]int
	var up [26]int
	for _, rune := range J {
		if rune >= 'a' && rune <= 'z' {
			low[rune-'a']++
		} else {
			up[rune-'A']++
		}
	}

	for _, rune := range S {
		if rune >= 'a' && rune <= 'z' {
			if low[rune-'a'] != 0 {
				counter++
			}
		} else {
			if up[rune-'A'] != 0 {
				counter++
			}
		}
	}
	return counter
}