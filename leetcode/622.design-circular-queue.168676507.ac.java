class MyCircularQueue {
    
    private int[] items;
    private int start = -1;
    private int tail = -1;
    private int len;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
       items = new int[k]; 
        len = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.isFull()) return false;
        if(this.isEmpty()){
            start = 0;
            tail = 0;
        } else if(tail == len - 1 && !this.isFull()){
            tail = 0;
        } else if(!this.isFull()){
            tail++;
        }
        items[tail] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(this.isEmpty()) return false;
        if(start == tail){
            start = -1;
            tail = -1;
        }else{
            if(start == len - 1) start = 0;
            else start++;
        }
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
      if(this.isEmpty()) return -1;  
      return items[start]; 
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
      if(this.isEmpty()) return -1;  
        return items[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return start == tail && start == -1;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (start ==0 && tail == len-1) || start == tail + 1;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
