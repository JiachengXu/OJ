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
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1!=null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode res = new ListNode(0);
        while(!s1.empty()||!s2.empty()){
            int v1 = s1.empty()?0:s1.pop();
            int v2 = s2.empty()?0:s2.pop();
            int sum = (v1+v2+carry);
            int v = sum % 10;
            carry = sum /10;
            res.val = v;
            ListNode ln = new ListNode(carry);
            ln.next = res;
            res = ln;
        }
        return res.val ==0? res.next:res;
    }
}