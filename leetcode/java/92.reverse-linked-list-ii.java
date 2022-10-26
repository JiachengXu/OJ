/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if (m == n)
      return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;
    ListNode slow = head;
    for (int i = 1; i < m; i++) {
      pre = pre.next;
      slow = slow.next;
    }

    ListNode fast = slow;
    for (int j = 1; j < n - m + 1; j++) {
      fast = fast.next;
    }

    ListNode prev = fast.next;
    ListNode end = fast.next;
    while (slow != end) {
      ListNode next = slow.next;
      slow.next = prev;
      prev = slow;
      slow = next;
    }
    pre.next = prev;
    return dummy.next;
  }
}