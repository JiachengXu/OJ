class MyCalendar {
    private List<int[]> events;
    public MyCalendar() {
        events = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] event:events){
            if(event[0]<=start&&start<event[1]){
                return false;
            }
            if(event[0]>=start&&end>event[0]){
                return false;
            }
        }
        int[] temp = new int[2];
        temp[0] = start;
        temp[1] = end;
        events.add(temp);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
