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
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }

    if (lists.length == 1) {
      return lists[0];
    }

    int middle = lists.length / 2;
    ListNode[] left = Arrays.copyOfRange(lists, 0, middle);
    ListNode[] right = Arrays.copyOfRange(lists, middle, lists.length);

    ListNode leftMerged = mergeKLists(left);
    ListNode rightMerged = mergeKLists(right);

    return merge(leftMerged, rightMerged);

  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode curr = new ListNode();
    ListNode head = curr;

    if (left.val < right.val) {
      curr.val = left.val;
      left = left.next;
    } else {
      curr.val = right.val;
      right = right.next;
    }

    while (left != null || right != null) {
      if (right == null) {
        curr.next = new ListNode(left.val);
        left = left.next;
      } else if (left == null) {
        curr.next = new ListNode(right.val);
        right = right.next;
      } else if (left.val <= right.val) {
        curr.next = new ListNode(left.val);
        left = left.next;
      } else {
        curr.next = new ListNode(right.val);
        right = right.next;
      }
      curr = curr.next;
    }

    return head;
  }


}
