/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode[] splitListToParts(ListNode root, int k) {
    int num = 0;
    ListNode curr = root;
    while (curr != null) {
      num++;
      curr = curr.next;
    }

    int morePart = num % k;
    int size = num / k;

    curr = root;
    ListNode[] res = new ListNode[k];

    for (int i = 0; i < k; i++) {
      ListNode head = curr;

      for (int j = 0; j < size + (i < morePart ? 1 : 0) - 1; j++) {
        if (curr != null) {
          curr = curr.next;
        }
      }
      if (curr != null) {
        ListNode prev = curr;
        curr = curr.next;
        prev.next = null;
      }
      res[i] = head;
    }
    return res;
  }
}