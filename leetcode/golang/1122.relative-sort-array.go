func relativeSortArray(arr1 []int, arr2 []int) []int {
    if len(arr2) == 0 {
        return arr1
    }
    m := map[int]int{}
    for _, v := range arr2 {
        m[v]++
    }
    
    var not []int
    var res []int
    
    for _, v := range arr1 {
        if m[v] == 0 {
            not = append(not, v)
        }else {
            m[v]++
        }
    }
    sort.Ints(not)
    
    for _, v := range arr2 {
        for i := 0; i < m[v] - 1; i++ {
            res = append(res, v)
        }
    }
    return append(res, not...)
}