/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true; 
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //Reverse the second half list
        ListNode newHead = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = newHead;
            newHead = slow;
            slow = next;
        }
        
        //Compare the 2 lists
        while(newHead!=null){
            if(head.val != newHead.val) return false;
            head = head.next;
            newHead = newHead.next;
        }
        return true;
        
    }
}
