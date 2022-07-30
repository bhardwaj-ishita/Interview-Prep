class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        return self.mid(head,head)
        
    def mid(self, fast, slow):
        if fast is None or fast.next is None:
            return slow
        
        return self.mid(fast.next.next,slow.next)
    
    
    
#Something I never realized is that linked list are like skewed trees, a node have only one child.
#So using recursion should be very natural to use

