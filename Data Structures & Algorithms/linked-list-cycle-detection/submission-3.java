/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null){
        return false;
    }
    ListNode curr = head;
    ListNode next = curr.next;
    int count = 0;
    while (next != null) {
      if (curr.val == next.val) {
        return true;
      }
      next = next.next;
      if (count % 2 == 0) curr = curr.next;
      count++;
    }
    return false;
  }


}
