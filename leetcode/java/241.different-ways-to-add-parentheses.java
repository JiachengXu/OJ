class Solution {
  public List<Integer> diffWaysToCompute(String input) {
    List<Integer> res = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      char c = input.charAt(i);
      if (c == '+' || c == '-' || c == '*') {
        List<Integer> part1 = diffWaysToCompute(input.substring(0, i));
        List<Integer> part2 = diffWaysToCompute(input.substring(i + 1));
        for (Integer k : part1) {
          for (Integer j : part2) {
            int temp = 0;
            switch (c) {
              case '+':
                temp = k + j;
                break;
              case '-':
                temp = k - j;
                break;
              case '*':
                temp = k * j;
                break;
            }
            res.add(temp);
          }
        }
      }
    }
    if (res.size() == 0) {
      res.add(Integer.valueOf(input));
    }
    return res;
  }
}