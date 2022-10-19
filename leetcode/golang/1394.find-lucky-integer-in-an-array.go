func findLucky(arr []int) int {
    m := map[int]int{}
    for _, v := range arr {
        m[v]++
    }
    
    res := -1
    for k, v := range m {
        if k == v && k > res {
            res = k
        }
    }
    return res
}