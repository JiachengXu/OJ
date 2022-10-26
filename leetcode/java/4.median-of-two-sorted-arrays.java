class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }
    int m = nums1.length;
    int n = nums2.length;
    int i = 0;
    int j = 0;
    int mmin = 0;
    int mmax = m;
    int max_left = 0;
    int min_right = 0;
    while (mmin <= mmax) {
      i = (mmin + mmax) / 2;
      j = (m + n + 1) / 2 - i;
      if (i < m && nums2[j - 1] > nums1[i]) {
        mmin = i + 1;
      } else if (i > 0 && nums1[i - 1] > nums2[j]) {
        mmax = i - 1;
      } else {
        if (i == 0) {
          max_left = nums2[j - 1];
        } else if (j == 0) {
          max_left = nums1[i - 1];
        } else {
          max_left = Math.max(nums1[i - 1], nums2[j - 1]);
        }
        if ((m + n) % 2 == 1) {
          return max_left;
        }
        if (i == m) {
          min_right = nums2[j];
        } else if (j == n) {
          min_right = nums1[i];
        } else {
          min_right = Math.min(nums1[i], nums2[j]);
        }
        return (min_right + max_left) / 2.;
      }
    }
    return (min_right + max_left) / 2.;
  }
}