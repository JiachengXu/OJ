/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null)
      return;
    TreeLinkNode curH = root;
    TreeLinkNode dummyHead = new TreeLinkNode(0);
    TreeLinkNode p = dummyHead;
    while (curH != null) {
      if (curH.left != null) {
        p.next = curH.left;
        p = p.next;
      }
      if (curH.right != null) {
        p.next = curH.right;
        p = p.next;
      }
      if (curH.next != null) {
        curH = curH.next;
      } else {
        curH = dummyHead.next;
        dummyHead.next = null;
        p = dummyHead;
      }
    }
  }
}