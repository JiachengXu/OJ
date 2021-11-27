func sortedSquares(nums []int) []int {
    index := len(nums) - 1
    for i := 0; i <= len(nums) - 1; i++ {
        if nums[i] >= 0 {
            index = i
            break
        } 
    }
    
    res := []int{}
    left, right := index - 1, index
    for left >= 0 || right <= len(nums) - 1 {
        lv, rv := 1000000000, 1000000000
        if left >= 0 {
            lv = nums[left] * nums[left]
        }
        if right <= len(nums) - 1 {
            rv = nums[right] * nums[right]
        }
        if lv < rv {
            res = append(res, lv)
            left--
        }else if lv > rv {
            res = append(res, rv)
            right++
        }else {
            res = append(res, lv)
            left--
            res = append(res, rv)
            right++
        }
    }
    return res
}

