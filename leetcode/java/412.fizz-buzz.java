class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            String temp = "";
            if(i % 3 == 0) temp += "Fizz";
            if(i % 5 == 0) temp += "Buzz";
            if(temp.length() == 0) temp = Integer.toString(i);
            res.add(temp);
        }
        return res;
    }
}