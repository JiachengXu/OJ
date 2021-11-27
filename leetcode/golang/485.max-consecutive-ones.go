func findMaxConsecutiveOnes(nums []int) int {
    sum := 0
    num := 0
    for _, v := range nums {
        if v == 1 {
            num++
            sum = max(sum, num)
        }else {
            num = 0
        }
    }
    return sum
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}