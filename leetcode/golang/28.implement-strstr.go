func strStr(haystack string, needle string) int {
    if len(needle) == 0 {
        return 0
    }
    if len(haystack) < len(needle) {
        return -1
    }
    n := len(needle)
    m := len(haystack)
    for i := range haystack {
        if i + n > m {
            return -1
        }
        if haystack[i:i+n] == needle {
            return i
        }
    }
    return -1
}