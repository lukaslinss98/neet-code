class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        arr = self.to_list(head)
        del arr[-n]
        return self.re_link(arr) if len(arr) > 0 else None

    def to_list(self, head) -> list[ListNode]:
        curr = head
        res = []
        while curr is not None:
            res.append(curr)
            curr = curr.next
        return res

    def re_link(self, arr: list[ListNode]):
        head = arr[0]
        for i, node in enumerate(arr):
            if len(arr) > i + 1:
                node.next = arr[i + 1]
            else:
                node.next = None
        return head
