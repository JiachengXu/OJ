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
  ListNode* mergeKLists(vector<ListNode*>& lists) {
    if (lists.size() == 0) return NULL;
    if (lists.size() == 1) return lists[0];
    return merge(lists, 0, lists.size() - 1);
  }

  ListNode* merge(vector<ListNode*>& lists, int left, int right) {
    if (left == right) return lists[left];
    if (left == right - 1) return merge2Lists(lists[left], lists[right]);
    ListNode* l1 = merge(lists, left, (left + right) / 2);
    ListNode* l2 = merge(lists, (left + right) / 2 + 1, right);
    return merge2Lists(l1, l2);
  }

  ListNode* merge2Lists(ListNode* list1, ListNode* list2) {
    if (list1 == NULL) return list2;
    if (list2 == NULL) return list1;
    ListNode* dummy = new ListNode(0);
    ListNode* head = dummy;
    while (list1 != NULL && list2 != NULL) {
      if (list1->val > list2->val) {
        head->next = list2;
        list2 = list2->next;
      } else {
        head->next = list1;
        list1 = list1->next;
      }
      head = head->next;
    }
    if (list1 == NULL) {
      head->next = list2;
    } else {
      head->next = list1;
    }
    return dummy->next;
  }
};