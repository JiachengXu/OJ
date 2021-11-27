func longestCommonPrefix(strs []string) string {
    if len(strs) == 0 {
        return ""
    }
    var res []byte
    i := 0
    for i < len(strs[0]) {
        c := strs[0][i]
        for _, v := range strs {
            if len(v) == 0 {
                return ""
            }
            if len(v) <= i || c != v[i] {
                return string(res)
            }
        }
        i++
        res = append(res, c)
    } 
    return string(res)
}