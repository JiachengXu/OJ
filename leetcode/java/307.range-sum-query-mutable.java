class NumArray {
  private int[] tree;
  private int n;
  public NumArray(int[] nums) {
    n = nums.length;
    tree = new int[2 * n];
    for (int i = 0; i < n; i++) {
      tree[n + i] = nums[i];
    }
    for (int i = n - 1; i > 0; i--) {
      tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
  }

  public void update(int i, int val) {
    i += n;
    int update = val - tree[i];
    while (i > 0) {
      tree[i] += update;
      i /= 2;
    }
  }

  public int sumRange(int i, int j) {
    int sum = 0;
    i += n;
    j += n;
    while (i <= j) {
      if (i % 2 == 1) {
        sum += tree[i];
        i++;
      }
      if (j % 2 == 0) {
        sum += tree[j];
        j--;
      }
      i /= 2;
      j /= 2;
    }
    return sum;
  }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */