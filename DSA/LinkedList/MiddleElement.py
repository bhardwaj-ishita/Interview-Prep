class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        return self.mid(head,head)
        
    def mid(self, fast, slow):
        if fast is None or fast.next is None:
            return slow
        
        return self.mid(fast.next.next,slow.next)
