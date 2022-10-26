class Solution {
  public String nextClosestTime(String time) {
    int start = 60 * Integer.parseInt(time.substring(0, 2));
    start += Integer.parseInt(time.substring(3));
    Set<Integer> set = new HashSet<>();
    for (char c : time.toCharArray()) {
      if (c == ':')
        continue;
      set.add(c - '0');
    }
    int elapsed = 24 * 60;
    int res = start;

    for (int h1 : set) {
      for (int h2 : set) {
        int hours = h1 * 10 + h2;
        if (hours < 24) {
          for (int m1 : set) {
            for (int m2 : set) {
              int mins = m1 * 10 + m2;
              if (mins < 60) {
                int cur = 60 * hours + mins;
                int cure = Math.floorMod(cur - start, 24 * 60);
                if (cure > 0 && cure < elapsed) {
                  res = cur;
                  elapsed = cure;
                }
              }
            }
          }
        }
      }
    }
    return String.format("%02d:%02d", res / 60, res % 60);
  }
}