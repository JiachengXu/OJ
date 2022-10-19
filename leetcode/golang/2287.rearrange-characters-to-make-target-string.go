func rearrangeCharacters(s string, target string) int {
    m := map[rune]int{}
    for _, c := range s {
        m[c]++
    }
    mt := map[rune]int{}
    for _, c := range target {
        mt[c]++
    }
    
    res := 1000
    for k, vt := range mt {
        v, ok := m[k]
        if !ok {
            return 0
        }
        if res > v/vt {
            res = v/vt
        }
        
    }
    return res
}