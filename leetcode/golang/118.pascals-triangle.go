func generate(num int) [][]int {
    numRows := make([][]int, num)
    for i := 0; i < num; i++ {
        numRows[i] = make([]int, i+1)
        numRows[i][0] = 1
        numRows[i][i] = 1
        if i > 1 {
            for j := 1; j < i; j ++ {
                numRows[i][j] = numRows[i-1][j-1] + numRows[i-1][j]
            }
        }
    }
    return numRows
}