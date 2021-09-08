/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        //devide list to 2 parts
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode part2 = slow.next;
        slow.next = null;
        //reverse the second part
        ListNode prev = null;
        ListNode cur = part2;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        //combine prev and dummy
        ListNode newHeader = new ListNode(0);
        cur = newHeader;
        ListNode cur1 = dummy.next;
        ListNode cur2 = prev;
        while(cur2!=null){
            cur.next = cur1;
            cur1 = cur1.next;
            cur = cur.next;
            cur.next = cur2;
            cur2 = cur2.next;
            cur = cur.next;
        }
        if(cur1!=null){
            cur.next = cur1;
        }
        head = newHeader.next;
    }
}
