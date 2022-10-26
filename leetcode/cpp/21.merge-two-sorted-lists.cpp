/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
 public:
  ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
    if (l1 == NULL) return l2;
    if (l2 == NULL) return l1;
    ListNode* dummy = new ListNode(0);
    ListNode* head = dummy;
    while (l1 != NULL && l2 != NULL) {
      if (l1->val > l2->val) {
        head->next = l2;
        l2 = l2->next;
      } else {
        head->next = l1;
        l1 = l1->next;
      }
      head = head->next;
    }
    if (l1 == NULL) {
      head->next = l2;
    } else {
      head->next = l1;
    }
    return dummy->next;
  }
};