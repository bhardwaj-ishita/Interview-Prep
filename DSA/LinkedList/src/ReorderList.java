import java.util.Stack;

/**
 * <h1>Reorder linked list</h1>
 * https://leetcode.com/problems/reorder-list/
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-05-29
 * */
public class ReorderList {

    /**
     * This method uses <b>Stack</b>.
     * Traverse the given list and push every node to the stack as you traverse
     * Find the mid size of the list
     * And then merge then merge the tail and the head of the list as you keep popping the stack with the head pointer
     * space complexity: O(n)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @return void You have to make changes in the given linked list without changing the head
     */
    public static void method1(SLL.Node head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        SLL.Node temp = head, slow;
        int size = 0;
        Stack<SLL.Node> stack = new Stack<>();
        while(temp != null) {
            size++;
            stack.push(temp);
            temp = temp.next;
        }

        temp = head;
        System.out.println(stack.peek().data);
        int i = 0;
        if(size%2 == 0)
            i = size/2 - 1;
        else if(size%2 != 0)
            i = size/2;

        while(i > 0) {
            slow = temp.next;
            temp.next = stack.pop();
            temp.next.next = slow;
            temp = slow;
            i--;
        }
        stack.pop().next = null;
    }


    /**
     * This method uses <b>two pointers</b>.
     * Find the middle point using tortoise and hare method.
     * Split the linked list into two halves using found middle point in step 1.
     * Reverse the second half.
     * Do alternate merge of first and second halves.
     * space complexity: O(1)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @return void You have to make changes in the given linked list without changing the head
     */
    public static void method2(SLL.Node head) {
        if(head == null || head.next == null || head.next.next == null)
            return;
        SLL.Node temp = head, slow = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }


        int i = 1;
        temp = head;
        while(i != (size)/2 ) {
            temp = temp.next;
            i++;
        }

        temp = ReverseLL.method2(temp.next);//returns the head of the reversed list; SAVE IT!!!

        SLL.Node prev, back;
        for(int j = 0; j < i; j++) {
            prev = slow.next;
            back = temp.next;
            slow.next = temp;
            temp.next = prev;
            slow = prev;
            temp = back;
        }
        slow.next = null;
    }

    /**
     * This method uses <b>recursion</b>.
     * Hold a pointer to the head node and go till the last node using recursion
     * Once the last node is reached, start swapping the last node to the next of head node
     * Move the head pointer to the next node
     * Repeat this until the head and the last node meet or come adjacent to each other
     * Once the Stop condition met, we need to discard the left nodes to fix the loop created in the list while swapping nodes.
     * space complexity: O(1)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @return void You have to make changes in the given linked list without changing the head
     */

    static SLL.Node left = null;//announce the left node globally to use in the rearrange method
    //because you need to save the head pointer and you can't do that without appointing another pointer to it
    // that can be used in both the methods

    public static void method3(SLL.Node head) {
        if(head != null) {
            left = head;
            rearrange(left);
        }
    }

    public static void rearrange(SLL.Node right) {
        if(right == null)
            return;

        SLL.Node prev = right;
        rearrange(right.next);//to reach the tail of the list
        //if(right != null && left != null) System.out.println("prev: " + prev.data + " right: " + right.data + " left: " + left.data);

        if(left == null)
            return;

        //when the left node is behind the right node: for both odd and even nodes
        //if odd nodes (left == right) elseif even nodes (left.next == right)
        if(left != right && left.next != right) {
            SLL.Node temp = left.next;
            left.next = right;
            right.next = temp;
            left = temp;
        }
        //when the right and left nodes have reached the base condition
        else if(left == right || left.next == right) {
            right.next = null;
            left = null;
        }
        else {
            left = null;
        }

    }

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        SLL sll = new SLL();

        sll.push(5);
        sll.push(4);
        sll.push(3);
        sll.push(2);
        sll.push(1);
        method3(sll.head);
        sll.printList(sll.head);
    }
}