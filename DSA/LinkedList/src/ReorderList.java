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
        method2(sll.head);
        sll.printList(sll.head);
    }
}
