func searchInsert(nums []int, target int) int {
    start, end := 0, len(nums) - 1
    for start <= end {
        middle := start + (end - start) / 2
        if nums[middle] == target {
            return middle
        }
        if nums[middle] > target {
            end = middle - 1
        }else {
            start = middle + 1 
        }
    }
    return start
}