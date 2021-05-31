/**
 * <h1>Sort List</h1>
 * https://leetcode.com/problems/sort-list/
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 *
 * The main problem here is to sort the list in O(nlogn) time and constant space.
 * The most efficient algorithm for sorting a linked list is MERGE SORT
 * Unlike QUICK SORT, merge sort take O(nlogn) time in all cases
 * The worst case in quick sort is O(n^2) and linked list doesn't allow random access to the nodes unlike arrays
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-05-30
 * */
public class SortList {

    public static SLL.Node middleNode(SLL.Node head) {
        if(head == null) {
            return head;
        }
        SLL.Node slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static SLL.Node sortMerged(SLL.Node a, SLL.Node b) {
        if(a == null) return b;
        else if(b == null) return a;
        SLL.Node head, pointer;
        head =  (a.data > b.data) ? b : a;
        if(a.data <= b.data) {
            pointer = a;
            pointer.next = sortMerged(a.next, b);
        }
        else if(a.data > b.data) {
            pointer = b;
            pointer.next = sortMerged(a, b.next);
        }
        return head;
    }

    /**
     * This method uses <b>Top Down Merge Sort</b>
     * This follows the divide and conquer strategy
     * Divide: divide the problem in similar yet smaller sub problems
     * Conquer: sort the sub problems and merge continuously
     *
     * Recursively divide the list from the middle until there is only one node left in each sub list
     * To find the middle, use the tortoise and hare algorithm
     * Recursively sort each list and merge them until we get a single linked list
     *
     * space complexity: O(nlogn)
     * time complexity: O(nlogn)
     * @param head The parameter is used to point at the head of an input linked list
     * @return SLL.Node returns the head pointer of the reversed linked list.
     */
    public static SLL.Node method1(SLL.Node head) {
        if(head == null || head.next == null)
            return head;
        SLL.Node mid = middleNode(head);
        SLL.Node middle = mid.next;
        mid.next = null;
        SLL.Node left = method1(head);
        SLL.Node right = method1(middle);
        head = sortMerged(left, right);
        return head;
    }

    /*
    Space Complexity: (log n)O(logn) , where nn is the number of nodes in linked list.
    Since the problem is recursive, we need additional space to store the recursive call stack.
    The maximum depth of the recursion tree is \log nlogn
     */

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        SLL sll = new SLL();

        sll.push(5);
        sll.push(-1);
        sll.push(3);
        sll.push(1);
        sll.push(2);
        sll.push(4);
        sll.printList(method1(sll.head));
    }
}
