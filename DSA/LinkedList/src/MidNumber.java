public class MidNumber {

    /**
     * space O(1)
     * time O(n)
     * */
    public SLL.Node method1(SLL.Node head) {
        SLL.Node slow = head, fast = head;

        while(fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * space O(n)
     * time O(n)
     * */
    public SLL.Node method2(SLL.Node head) {
        SLL.Node[] A = new SLL.Node[100];
        SLL.Node temp = head;
        int i = 0;
        while(temp != null && i < A.length) {
            A[i++] = temp;
            temp = temp.next;
        }

        return A[i/2];
    }

}
