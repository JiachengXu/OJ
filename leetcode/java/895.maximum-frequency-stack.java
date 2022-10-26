class FreqStack {
  private Map<Integer, Integer> map;
  private Map<Integer, Stack<Integer>> stacks;
  private int maxFreq;
  public FreqStack() {
    map = new HashMap<>();
    stacks = new HashMap<>();
    maxFreq = 0;
  }

  public void push(int x) {
    int temp = map.getOrDefault(x, 0) + 1;
    maxFreq = Math.max(maxFreq, temp);
    map.put(x, temp);
    if (!stacks.containsKey(temp))
      stacks.put(temp, new Stack<>());
    stacks.get(temp).push(x);
  }

  public int pop() {
    int res = stacks.get(maxFreq).pop();
    map.put(res, maxFreq - 1);
    if (stacks.get(maxFreq).size() == 0)
      maxFreq--;
    return res;
  }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */