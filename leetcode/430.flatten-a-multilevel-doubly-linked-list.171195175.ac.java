/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null) return head; 
        Node cur = head;
        while(cur != null){
            if(cur.child == null){
                cur = cur.next;
            }else{
                Node tail = cur.child;
                while(tail.next != null){
                    tail = tail.next;
                }
                tail.next = cur.next;
                if(cur.next != null){
                    cur.next.prev = tail;
                }
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
        }
        return head;
    }
}
