func findDiagonalOrder(mat [][]int) []int {
    m := len(mat)
    n := len(mat[0])
    max := m + n - 1
    res := []int{}
    for x := 0; x < max; x++ {
        if x % 2 == 0 {
            for i := 0; i <= x; i++ {
                if i >= n || x - i >= m {
                    continue
                }
                res = append(res, mat[x - i][i])
            }
        }else {
            for j := 0; j <= x; j++ {
                if j >= m ||  x - j >=n {
                    continue
                }
                res = append(res, mat[j][x - j])
            }
        }
    }
    return res
}