class Solution {
  public String getPermutation(int n, int k) {
    int[] factorial = new int[n + 1];
    factorial[0] = 1;
    for (int i = 1; i < factorial.length; i++) {
      factorial[i] = i * factorial[i - 1];
    }
    LinkedList<Integer> num = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      num.add(i);
    }

    k--;
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
      int index = k / factorial[n - i];
      sb.append(String.valueOf(num.get(index)));
      num.remove(index);
      k -= index * factorial[n - i];
    }
    return sb.toString();
  }
}