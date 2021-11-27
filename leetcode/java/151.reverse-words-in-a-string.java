public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        reverse(words);
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.trim().length() > 0) {
                sb.append(word);
                sb.append(' ');
            }
        }
        return sb.toString().trim();
    }
    
    public void reverse(String[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}