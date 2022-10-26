/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null)
      return head;
    ListNode cur = head;
    int len = 1;
    while (cur.next != null) {
      cur = cur.next;
      len++;
    }
    if (len < k)
      return head;
    cur = head;
    int j = 0;
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (j < len / k) {
      int i = 0;
      ListNode pre = null;
      ListNode tail2 = tail;
      while (i < k) {
        ListNode temp = cur.next;
        cur.next = pre;
        pre = cur;
        if (i == 0) {
          tail = pre;
        }
        cur = temp;
        i++;
      }
      tail2.next = pre;
      j++;
    }
    tail.next = cur;
    return dummy.next;
  }
}