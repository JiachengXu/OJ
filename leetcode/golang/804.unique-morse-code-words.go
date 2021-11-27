func uniqueMorseRepresentations(words []string) int {
    if words == nil || len(words) == 0 {
        return 0
    }
    morseCode := [26]string{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."}
    wordMap := make(map[string]struct{})
    for _, word := range words {
        temp := ""
        for _, rune := range word {
            temp += morseCode[rune-'a']
        }
        wordMap[temp] = struct{}{}

    }
    return len(wordMap)
}