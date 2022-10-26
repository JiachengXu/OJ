class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
    if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
      return new int[0];
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();
    for (int num : nums1) {
      if (map.containsKey(num))
        map.put(num, map.get(num) + 1);
      else
        map.put(num, 1);
    }

    for (int num : nums2) {
      if (map.containsKey(num) && map.get(num) > 0) {
        res.add(num);
        map.put(num, map.get(num) - 1);
      }
    }

    int[] re = new int[res.size()];
    for (int i = 0; i < re.length; i++) {
      re[i] = res.get(i);
    }
    return re;
  }
}