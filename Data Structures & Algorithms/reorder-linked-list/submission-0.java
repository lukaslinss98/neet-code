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
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;

    Stack<ListNode> stack = new Stack<>();
    int length = 0;
    ListNode curr = head;

    while (curr != null) {
      stack.add(curr);
      curr = curr.next;
      length++;
    }

    for (int i = length / 2; i > 0; i--) {
      ListNode next = head.next;
      ListNode popped = stack.pop();

      head.next = popped;
      popped.next = next;

      head = next;
    }
    head.next = null;
  }
}
