/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null || l2 != null){
            int sum = carry;
            sum += l1 == null? 0 : l1.val;
            sum += l2 == null? 0 : l2.val;
            int val = sum % 10;
            ListNode temp = new ListNode(val);
            cur.next = temp;
            cur = cur.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            carry = sum / 10;
        }
        if(carry != 0) cur.next = new ListNode(1);
        return dummy.next;
    }
}
