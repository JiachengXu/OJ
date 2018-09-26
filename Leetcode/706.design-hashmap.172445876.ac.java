class MyHashMap {

    int bucket = 1000;
    int size = 1001;
    int[][] container;
    /** Initialize your data structure here. */
    public MyHashMap() {
        container = new int[bucket][];
    }
    private int hash(int key){
        return key % bucket;
    }
    private int pos(int key){
        return key / bucket;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = hash(key);
        if(container[hash] == null) container[hash] = new int[size];
        container[hash][pos(key)] = value + 1;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = hash(key);
        int pos = pos(key);
        if(!contains(hash, pos)) return -1;
        return container[hash][pos] - 1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = hash(key);
        int pos = pos(key);
        if(contains(hash, pos)) container[hash][pos] = 0;
        
    }
    
    boolean contains(int hash, int pos){
        return container[hash] != null && container[hash][pos] != 0;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
