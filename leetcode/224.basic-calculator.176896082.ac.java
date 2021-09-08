class Solution {
    public int calculate(String s) {
        Stack<Integer> numbers = new Stack<>();
        int res = 0;
        int sign = 1;
        int number = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                number = number * 10 + (c - '0');
            }else if(c == '+'){
                res += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                res += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                numbers.push(res);
                numbers.push(sign);
                res = 0;
                sign = 1;
            }else if(c == ')'){
                res += sign * number;
                res *= numbers.pop();
                res += numbers.pop();
                number = 0;
                sign = 1;
            }
        }
        if(number != 0) res += sign * number;
        return res;
    }
}
