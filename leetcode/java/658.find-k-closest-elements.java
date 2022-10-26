class Solution {
  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    LinkedList<Integer> res = new LinkedList<>();
    if (arr == null || arr.length == 0)
      return res;
    int l = 0, r = arr.length - 1;
    int mid = 0;
    while (l < r) {
      mid = l + (r - l) / 2;
      if (arr[mid] > x)
        r = mid - 1;
      else if (arr[mid] < x)
        l = mid + 1;
      else
        break;
    }

    int i = mid, j = mid + 1;
    while (k > 0) {
      if (i >= 0 && j <= arr.length - 1) {
        if (x - arr[i] <= arr[j] - x) {
          res.addFirst(arr[i]);
          i--;
        } else {
          res.add(arr[j]);
          j++;
        }
      } else if (i < 0) {
        res.add(arr[j]);
        j++;
      } else {
        res.addFirst(arr[i]);
        i--;
      }
      k--;
    }
    return res;
  }
}