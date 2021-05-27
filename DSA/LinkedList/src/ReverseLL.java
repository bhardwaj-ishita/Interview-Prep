public class ReverseLL {

    /**
     * space O(n)
     * time O(n)
     * */
    public static SLL.Node myMethod(SLL.Node head) {
        SLL.Node[] A = new SLL.Node[5000];
        SLL.Node temp = head;
        int i = 0;
        while(temp != null) {
            A[i++] = temp;
            temp = temp.next;
        }

        head = A[i-1];
        System.out.println(head);
        temp = head;
        int size = i-2;
        while(size >= 0) {
            temp.next = A[size--];
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    /**
     * space O(1)
     * time O(n)
     * */
    public static SLL.Node method1(SLL.Node head) {
        if(head == null || head.next == null)
            return head;
        SLL.Node temp = head, prev = null;
        while(temp.next != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        head.next = prev;
        return head;
    }

    /**
     * space O(n)
     * time O(n)
     * */
    public static SLL.Node method2(SLL.Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        SLL.Node temp;
        temp = method2(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void main(String[] args) {
        SLL sll = new SLL();

        sll.push(3);
        sll.push(5);
        sll.push(9);
        sll.push(1);
        sll.push(43);
        System.out.println(sll.head.data);
        sll.printList(method2(sll.head));
    }
}
