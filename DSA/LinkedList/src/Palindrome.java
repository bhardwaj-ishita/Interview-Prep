import java.util.Stack;

/**
 * <h1>Palindrome Linked List</h1>
 * https://leetcode.com/problems/palindrome-linked-list/
 * Given the head of a singly linked list, return true if it is a palindrome.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-05-28
 * */
public class Palindrome {

    /**
     * This method we have <b>reversed</b> the second half of the list
     * Find the size of the list
     * Reach the mid of the list
     * Reverse the second half of the list
     * Now we have two pointers at the head of the list and at the end of the list
     * *a1 --> a2 --> a3 <-- a4 <-- *a5
     * Check the values of the pointer position together and move the pointers forward until you reach the mid of the pointer
     * space complexity: O(1)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @return boolean tells if the list is a palindrome or not
     */
    public static boolean method1(SLL.Node head) {
        if(head == null || head.next == null)
            return true;

        SLL.Node temp = head;

        //find the size
        int size = 1;
        while(temp.next != null) {
            size++;
            temp = temp.next;
        }

        //reach the mid
        int i = 1;
        temp = head;
        SLL.Node back;
        if(size%2 == 0) {
            while(i != (size)/2) {
                temp = temp.next;
                i++;
            }
        }
        else if(size%2 != 0) {
            while(i != (size + 1)/2) {
                temp = temp.next;
                i++;
            }
        }

        //reversed the second half of the list
        temp = ReverseLL.method1(temp);

        //checked the two halves simultaneously
        back = head;
        for(int j = 0; j < size/2; j++) {
            if(back.data != temp.data) return false;
            back = back.next;
            temp = temp.next;
        }
        return true;
    }

    /**
     * This method uses <b>Stack</b> to store the list
     * A simple solution is to use a stack of list nodes. This mainly involves three steps.
     * Traverse the given list from head to tail and push every visited node to stack.
     * Traverse the list again. For every visited node, pop a node from the stack and compare data
     * of popped node with the currently visited node.
     * If all nodes matched, then return true, else false.
     * space complexity: O(n)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @return boolean tells if the list is a palindrome or not
     */
    public static boolean method2(SLL.Node head) {
        if(head == null || head.next == null)
            return true;
        Stack<SLL.Node> stack = new Stack<>();
        SLL.Node temp = head;
        while(temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while(!stack.isEmpty()) {
            if(temp.data != stack.peek().data) {
                return false;
            }
            temp = temp.next;
            stack.pop();
        }
        return true;
    }

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        SLL sll = new SLL();

        sll.push(1);
        sll.push(2);
        sll.push(3);
        sll.push(2);
        sll.push(1);
        System.out.println(method2(sll.head));
    }
}
