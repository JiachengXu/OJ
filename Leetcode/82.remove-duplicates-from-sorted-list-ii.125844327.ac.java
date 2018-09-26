/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = head;
        while(right!=null){
            while(right.next!=null&&right.val==right.next.val){
                right = right.next;
            }
            if(left.next == right){
                left = left.next;
            }else{
                left.next = right.next;
            }
            right = right.next;
        }
        return dummy.next;
    }
}
