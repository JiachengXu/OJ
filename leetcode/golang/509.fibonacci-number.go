func fib(n int) int {
    if n == 0 {
        return 0
    }
    if n == 1 {
        return 1
    }
    v2 := 0
    v1 := 1
    res := 0
    for i := 2; i <= n; i ++ {
        cur := v1 + v2
        v2 = v1
        v1 = cur
        res = cur
        
    }
    return res
}