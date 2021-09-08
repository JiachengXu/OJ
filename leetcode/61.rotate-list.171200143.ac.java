/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) return head;
        int len = 1;
        ListNode iter = head;
        while(iter.next != null){
            iter = iter.next;
            len++;
        }
        k = k % len;
        ListNode iter2 = head;
        
        for(int i = 0; i < len - k - 1; i++){
            iter2 = iter2.next;
        }
        iter.next = head;
        System.out.println(iter.val);
        ListNode newHead = iter2.next;
        iter2.next = null;
        return newHead;
    }
}
