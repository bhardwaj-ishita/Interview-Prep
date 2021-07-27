public class RotateList {
    /**
     * we first create a circular list
     * then iterate again to find the kth node and k-1th node
     * to break the connection between them
     *
     * and assign the kth node "head"
     * return head
     * @param head
     * @param k
     * @return
     */
    public SLL.Node rotate(SLL.Node head, int k) {
        SLL.Node temp = head;
        while(temp.next!=null) {
            temp = temp.next;
        }
        SLL.Node curr = head;
        temp.next = head;
        while(k-->1) {
            curr = curr.next;
        }
        SLL.Node kNode = curr.next;
        SLL.Node prev = curr;
        prev.next = null;

        head = kNode;
        return head;
    }
}

