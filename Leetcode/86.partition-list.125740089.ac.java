/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummySmall = new ListNode(0);
        ListNode dummyBig = new ListNode(0);
        ListNode big = dummyBig;
        ListNode small = dummySmall;
        while(head!=null){
            if(head.val<x){
                small.next = head;
                small = small.next;
            }else{
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        big.next = null;
        small.next = dummyBig.next;
        return dummySmall.next;
    }
}
