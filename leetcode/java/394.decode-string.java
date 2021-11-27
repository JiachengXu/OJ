class Solution {
    public String decodeString(String s) {
        if(s == null || s.length() == 0) return s;
        char[] tokens = s.toCharArray();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i] != ']'){
                st.push(tokens[i]);
            }else{
                LinkedList<Character> temp = new LinkedList<>();
                while(st.peek()!='['){
                    temp.addFirst(st.pop());
                }
                st.pop();
                int time = 0;
                int k = 1;
                while(!st.isEmpty() && (st.peek() - '0' >= 0 && st.peek() - '0' <= 9)){
                    time += Character.getNumericValue(st.pop()) * k;
                    System.out.println(time);
                    k*=10;
                }
                for(int j = 0; j < time; j++){
                    for(Character c : temp){
                        st.push(c);
                    }
                }
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}