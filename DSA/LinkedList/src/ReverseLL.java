import java.util.Stack;

/**
 * <h1>Reverse linked list</h1>
 * https://leetcode.com/problems/reverse-linked-list/
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-05-27
 * */

public class ReverseLL {

    /**
     * This method has a <b>Node Array</b> of max size
     * As we'll traverse the list we'll save the pointers of the whole list
     * As we reach the end of the list with size i-1, we'll appoint the last index as head and
     * traverse the Node Array in the reverse direction while appointing the next node of the iterator
     * and end the list with a null
     * space complexity: O(n)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @return SLL.Node returns the head pointer of the reversed linked list.
     */
    public static SLL.Node myMethod(SLL.Node head) {
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
     * This method has <b>two pointers</b> and the parameter head pointer
     * We'll the save the next node to the head
     * Put the previous node as next to the head
     * Iterate the prev to the head pointer
     * Iterate the head to the temp pointer
     * space complexity: O(1)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @return SLL.Node returns the head pointer of the reversed linked list.
     */
    public static SLL.Node method1(SLL.Node head) {
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

    /**
     * This is a <b>recursive method</b>
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
     *
     * here the recursion takes place from the end node to the first i.e. the links are getting reversed from the end node
     *
     * space complexity: O(n)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @return SLL.Node returns the head pointer of the reversed linked list.
     */
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

    /**
     * This is a <b>tail recursive method</b>
     * The only difference between method 3 and tail recursion is that instead of calling the method in the middle of the
     * algorithm, we call the method at the end/tail of the method
     *
     * Also, here the recursion takes place from the first node to the last i.e. the links are getting reversed from the starting node
     *
     * space complexity: O(n)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @param prev The parameter is used to point at the node previous to the head pointer of an input linked list
     * @return SLL.Node returns the head pointer of the reversed linked list.
     */
    public static SLL.Node method4(SLL.Node head, SLL.Node prev) {
        if(head == null)
            return head;
        if(head.next == null) {
            head.next = prev;
            return head;
        }

        SLL.Node temp = head.next;
        head.next = prev;
        prev = head;
        head = method4(temp, prev);
        return head;
    }

    /**
     * This is a method uses <b>Stack</b>
     * We make a Stack of all the Nodes in the linked list
     * We keep pushing the node as we traverse the linked list till we reach the end
     * the last node is appointed the head pointer
     *
     * We need to return the head, which we've attained but the nodes are still not connected in reverse order
     * One by one we'll pop the stacks and connected it to the next stack node and severe the former connection
     * As the loop ends we'll connect the last node to null to end the linked list
     * space complexity: O(n)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @return SLL.Node returns the head pointer of the reversed linked list.
     */
    public static SLL.Node method5(SLL.Node head) {
        Stack<SLL.Node> stack = new Stack<>();
        SLL.Node temp = head;
        while(temp.next != null) {
            stack.push(temp);
            temp = temp.next;
        }

        head = temp;
        SLL.Node slow;
        stack.pop();
        while(!stack.isEmpty()) {
            slow = stack.pop();
            temp.next = slow;
            slow.next = null;
            temp = slow;
        }
        temp.next = null;
        return head;
    }


    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        SLL sll = new SLL();

        sll.push(3);
        sll.push(5);
        sll.push(9);
        sll.push(1);
        sll.push(43);
        sll.printList(method5(sll.head));
    }
}
