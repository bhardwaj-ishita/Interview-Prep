/**
 * <h1>Remove Duplicates from Sorted List</h1>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-01
 * */
public class RemoveDuplicates {

    /**
     * This method is an <b>Iterative Method</b>
     * We take a corner case if the head is null or next of head is null then return null and head respectively
     * Appointing a current pointer to head we traverse the list until it reaches the end
     * During the traversal if current and current.next are same then make current.next = current.next.next
     *
     * INPUT: node1 --> current(a1) --> current.next(a1) --> current.next.next(a2) --> null
     * OUTPUT: node1 --> current(a1) --> current.next.next(a2) --> null
     *
     * If not same then move the current pointer forward
     *
     * space complexity: O(1)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @return SLL.Node returns the head pointer of the linked list.
     */
    public static SLL.Node method1(SLL.Node head) {
        if(head == null || head.next == null)
            return head;
        SLL.Node current = head;
        while(current.next != null) {
            if(current.data == current.next.data) {
                current.next = current.next.next;
            }
            else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * This method is an <b>Recursive Method</b>
     * The method is very similar to iterative method
     * It's just that when we want to move the pointer further or when we want the loop start from the top we call the function
     *
     * We take a corner case if the head is null or next of head is null then return null and head respectively
     * Appointing a current pointer to head we traverse the list until it reaches the end
     * During the traversal if current and current.next are same then make current.next = current.next.next
     *
     * INPUT: node1 --> current(a1) --> current.next(a1) --> current.next.next(a2) --> null
     * OUTPUT: node1 --> current(a1) --> current.next.next(a2) --> null
     *
     * If not same then move the current pointer forward
     *
     * space complexity: O(1)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @return SLL.Node returns the head pointer of the linked list.
     */
    public static SLL.Node method2(SLL.Node head) {
        if(head == null || head.next == null)
            return head;

        if(head.data == head.next.data) {
            head.next = head.next.next;
            method2(head);
        }
        else {
            method2(head.next);
        }
        return head;
    }

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        SLL sll = new SLL();

        sll.push(3);
        sll.push(3);
        sll.push(2);
        sll.push(1);
        sll.push(1);

        sll.printList(method2(sll.head));
    }
}
