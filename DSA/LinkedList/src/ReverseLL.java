/**
 * <h1>Reverse linked list</>
 * https://leetcode.com/problems/reverse-linked-list/
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-05-27
 * */
public class ReverseLL {

    public static SLL.Node myMethod(SLL.Node head) {
        /**
         * This method has a Node Array of max size
         * As we'll traverse the list we'll save the pointers of the whole list
         * As we reach the end of the list with size i-1, we'll appoint the last index as head and
         * traverse the Node Array in the reverse direction while appointing the next node of the iterator
         * and end the list with a null
         * space complexity: O(n)
         * time complexity: O(n)
         * @param (SLL.Node head) The parameter is used to point at the head of an input linked list
         * @return SLL.Node returns the head pointer of the reversed linked list.
         */
        SLL.Node[] A = new SLL.Node[5000];
        SLL.Node temp = head;
        int i = 0;
        while(temp != null) {
            A[i++] = temp;
            temp = temp.next;
        }
        head = A[i-1];
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
        /**
         * This method has two pointers and the parameter head pointer
         * We'll the save the next node to the head
         * Put the previous node as next to the head
         * Iterate the prev to the head pointer
         * Iterate the head to the temp pointer
         * space complexity: O(1)
         * time complexity: O(n)
         * @param (SLL.Node head) The parameter is used to point at the head of an input linked list
         * @return SLL.Node returns the head pointer of the reversed linked list.
         */
        if(head == null || head.next == null)
            return head;
        SLL.Node temp = head, prev = null;
        while(temp.next != null) {
            temp = head.next;//save the next node
            head.next = prev;//make the next to head node as prev
            prev = head;//iterate prev to head
            head = temp;//iterate head to temp which was saved initially
        }
        head.next = prev;
        return head;
    }

    public static SLL.Node method2(SLL.Node head) {
        /**
         * This is a recursive method
         * We have a base condition if the list is empty or have only one node then return the head itself
         * We take a temporary pointer and apply recursion for the node next to the current pointer
         * As the recursive functions unwrap, we simply do two things:
         * 1 --> pass down the head of the reversed linked list i.e the last node
         * 2 --> reverse the pointer of the two current nodes (adjacent) from
         * Step 2.1: [a1(head) --> a2(head.next) --> null(head.next.next)]
         * Step 2.2: [a1(head) --> a2(head.next) --> a1(head.next.next == head)]
         * Step 2.3: [a1(head) --> null(head.next) | a2(head.next) --> a1(head.next.next == head) --> null]
         * Simplified 2.3: a2(head.next) --> a1(head.next.next == head) --> null
         * again here head only represents the head in the current stack; last node is still the all over head being passed down
         * space complexity: O(n)
         * time complexity: O(n)
         * @param (SLL.Node head) The parameter is used to point at the head of an input linked list
         * @return SLL.Node returns the head pointer of the reversed linked list.
         */
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
