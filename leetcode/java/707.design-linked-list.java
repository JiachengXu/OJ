class MyLinkedList {
    
    private int len;
    private Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        len = 0;
        head = new Node(0);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= len){
            return -1;
        }
        Node cur = head;
        while(index>=0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node cur = new Node(val);
        cur.next = head.next;
        cur.prev = head;
        head.next = cur;
        head.next.prev = cur;
        len++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        Node add = new Node(val);
        cur.next = add;
        add.prev = cur;
        len++;
        
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > len) return;
        else if(index == len) addAtTail(val);
        else{
            Node add = new Node(val);
            Node cur = head;
            while(index > 0){
                cur = cur.next;
                index--;
            }
            add.next = cur.next;
            add.prev = cur;
            cur.next = add;
            cur.next.prev = add;
            len++;
        }
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= len) return;
        Node cur = head;
        while(index > 0){
            cur = cur.next;
            index --;
        }
        cur.next = cur.next.next;
        if(cur.next != null){
            cur.next.prev = cur;
        }
        len--;
    }
    
    private class Node{
        Node next;
        Node prev;
        int val;
        public Node(int val){
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */