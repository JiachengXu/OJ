class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int m = nums1.length;
    int n = nums2.length;
    int i, j, maxLeft, minRight;
    int mmin = 0;
    int mmax = m;

    while (mmin <= mmax) {
      i = (mmin + mmax) / 2;
      j = (m + n + 1) / 2 - i;

      int nums1LeftMax = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
      int nums1RightMin = (i == m) ? Integer.MAX_VALUE : nums1[i];
      int nums2LeftMax = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
      int nums2RightMin = (j == n) ? Integer.MAX_VALUE : nums2[j];

      if (nums1LeftMax <= nums2RightMin && nums2LeftMax <= nums1RightMin) {
        maxLeft = Math.max(nums1LeftMax, nums2LeftMax);
        if ((m + n) % 2 == 1) {
          return (double) maxLeft;
        }
        minRight = Math.min(nums1RightMin, nums2RightMin);
        return (maxLeft + minRight) / 2.0;
      } else if (nums1LeftMax > nums2RightMin) {
        mmax = i - 1;
      } else {
        mmin = i + 1;
      }
    }
    throw new IllegalArgumentException("Input arrays are not sorted.");
  }
}
