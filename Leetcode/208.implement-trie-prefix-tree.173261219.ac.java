class Trie {
    private TrieNode node;

    /** Initialize your data structure here. */
    public Trie() {
        node = new TrieNode(26);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = node;
        for(int i = 0; i < word.length(); i++){
            if(cur.children[word.charAt(i) - 'a'] == null){
                cur.children[word.charAt(i) - 'a'] = new TrieNode(26); 
            }
            cur = cur.children[word.charAt(i) - 'a'];
            if(i == word.length() - 1) cur.isWord = true;
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = node;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = node;
        for(char c : prefix.toCharArray()){
            if(cur.children[c - 'a'] == null) return false;
            cur = cur.children[c - 'a'];
        }
        return true;
    }
    
    class TrieNode{
        boolean isWord;
        TrieNode[] children;
        
        TrieNode(int num){
            children = new TrieNode[num];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
