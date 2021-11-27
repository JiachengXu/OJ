class MapSum {

    Node node;
    /** Initialize your data structure here. */
    public MapSum() {
        node = new Node();
    }
    
    public void insert(String key, int val) {
        Node cur = node;
        for(int i = 0; i < key.length(); i++){
            if(cur.children[key.charAt(i)] == null){
                cur.children[key.charAt(i)] = new Node();
            }
            cur = cur.children[key.charAt(i)];
        }
        cur.value = val;
    }
    
    public int sum(String prefix) {
        Node cur = node;
        int res = 0;
        for(char c : prefix.toCharArray()){
            if(cur.children[c] == null) return res;
            cur = cur.children[c];
        }
        
        Stack<Node> st = new Stack<>();
        st.push(cur);
        while(!st.isEmpty()){
            Node temp = st.pop();
            res += temp.value;
            for(Node child : temp.children){
                if(child != null) st.push(child);
            }
        }
        return res;
        
    }
    
    class Node{
        int value;
        int sum;
        Node[] children;
        Node(){
            children = new Node[256];
        }
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */