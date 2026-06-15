# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        visited = set()
        while headA is not None or headB is not None:
            if headA == headB or headA in visited:
                return headA
            if headB in visited:
                return headB

            if headA != None:
                visited.add(headA)
                headA = headA.next

            if headB != None:
                visited.add(headB)
                headB = headB.next

        return None
