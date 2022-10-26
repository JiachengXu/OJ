/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    RandomListNode iter = head;
    while (iter != null) {
      RandomListNode copy = new RandomListNode(iter.label);
      RandomListNode next = iter.next;
      iter.next = copy;
      copy.next = next;
      iter = next;
    }

    iter = head;
    while (iter != null) {
      if (iter.random != null) {
        iter.next.random = iter.random.next;
      }
      iter = iter.next.next;
    }

    iter = head;
    RandomListNode dummy = new RandomListNode(0);
    RandomListNode itercp = dummy;
    while (iter != null) {
      RandomListNode cp = iter.next;
      RandomListNode next = iter.next.next;
      iter.next = next;
      itercp.next = cp;
      iter = next;
      itercp = cp;
    }
    return dummy.next;
  }
}