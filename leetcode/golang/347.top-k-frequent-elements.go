func topKFrequent(nums []int, k int) []int {

	counters := make(map[int]int)
	for _, v := range nums {
		counters[v]++
	}

	feqs := make([][]int, len(nums)+1)
	for i := range feqs {
		feqs[i] = make([]int, 0)
	}

	for k, v := range counters {
		feqs[v] = append(feqs[v], k)
	}

	res := make([]int, 0)
	j := k
	for i := len(nums); i >= 0 && j > 0; i-- {
		if len(feqs[i]) != 0 {
			for _, v := range feqs[i] {
				res = append(res, v)
				j--
				if len(res) == k {
					return res
				}
			}
		}
	}

	return res
}