class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode(next=head)
        lptr = dummy
        rptr = head

        while n > 0 and rptr:
            rptr = rptr.next
            n -= 1
        while rptr:
            lptr = lptr.next
            rptr = rptr.next

        lptr.next = lptr.next.next

        return dummy.next
