class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>();
    if (numRows == 0)
      return res;
    for (int i = 0; i < numRows; i++) {
      List<Integer> temp = new ArrayList<>();
      for (int j = 0; j <= i; j++) {
        if (j == 0)
          temp.add(1);
        else if (j == i)
          temp.add(1);
        else {
          temp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
        }
      }
      res.add(temp);
    }
    return res;
  }
}