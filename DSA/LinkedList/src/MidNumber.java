/**
 * <h1>Middle of a linked list</>
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * If there are two middle nodes, return the second middle node.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-05-27
 * */
public class MidNumber {

    public static SLL.Node method1(SLL.Node head) {
        /**
         * This method has two pointers, slow and fast.
         * slow goes one node at a time whereas fast skips a node at a time.
         * fast = 2 * slow
         * So when fast reaches the end of the list, slow would be in the middle of the list
         * space complexity: O(1)
         * time complexity: O(n)
         * @param (SLL.Node head) The parameter is used to point at the head of an input linked list
         * @return SLL.Node returns the Node in the middle of the linked list.
         */
        SLL.Node slow = head, fast = head;

        while(fast.next != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    public static SLL.Node method2(SLL.Node head) {
        /**
         * This method has a Node Array with max size
         * A temporary pointer is pointed at the head
         * In the while loop, as we traverse the linked list, we save the pointers in the Node Array until
         * we've completed the list
         * space complexity: O(n)
         * time complexity: O(n)
         * @param (SLL.Node head) The parameter is used to point at the head of a linked list
         * @return SLL.Node[i/2] returns the Node in the middle of the linked list, where i is the size of the list
         */
        SLL.Node[] A = new SLL.Node[100];
        SLL.Node temp = head;
        int i = 0;
        while(temp != null && i < A.length) {
            A[i++] = temp;
            temp = temp.next;
        }
        return A[i/2];
    }

    /**
     * Driver code
     * */
    public static void main(String[] args) {
        SLL sll = new SLL();

        sll.push(3);
        sll.push(5);
        sll.push(9);
        sll.push(1);
        sll.push(43);
        System.out.println(sll.head.data);
        sll.printList(method1(sll.head));
    }

}
