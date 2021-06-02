import java.util.HashSet;

/**
 * <h1>Linked List Cycle</h1>
 * https://leetcode.com/problems/linked-list-cycle/
 * https://leetcode.com/problems/linked-list-cycle-ii/
 *
 * Both almost similar just the constraints are stretched more
 * Not all methods can be applied in the second one
 *
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-2
 * */
public class DetectLoop {

    /**
     * This method uses <b>Hashing</b>
     * As we traverse we save the node pointer in the HashSet
     * If the pointer has ever been saved previously then there is a loop in the list
     * If not then move forward until the temporary pointer reaches null then return false
     * As no node pointer has been repeated
     * space complexity: O(n) n is the space required to store the value in hashmap.
     * time complexity: O(n) Only one traversal of the loop is needed.
     * @param head The parameter is used to point at the head of a linked list
     * @return boolean returns the list actually contains a cycle(true) or not(false)
     */
    public static boolean method1(CLL.Node head) {
        if(head == null || head.next == null) return false;
        CLL.Node temp = head;
        HashSet<CLL.Node> s = new HashSet<CLL.Node>();
        while(temp != null) {
            if(s.contains(temp)) return true;
            s.add(temp);
            temp = temp.next;
        }
        return false;
    }

    /**
     * In this method we <b>Mark the nodes</b> without changing the core linked list class
     * As we traverse we mark the nodes by connecting them to a temporary node and moving forward
     * If in the loop you find the next of the pointer as temp then there is a loop
     * But if we found null then it is false
     * Time complexity: O(n) Only one traversal of the loop is needed.
     * Auxiliary Space: O(1) There is no space required.
     * @param head The parameter is used to point at the head of a linked list
     * @return boolean returns the list actually contains a cycle(true) or not(false)
     */
    public static boolean method2(CLL.Node head) {
        if(head == null || head.next == null) return false;
        CLL.Node temp = new CLL.Node();
        CLL.Node pointer = head;
        while(pointer != null) {
            if(pointer.next == temp) return true;
            pointer.next = temp;
            pointer = pointer.next;
        }
        return false;
    }

    /**
     * In this method we <b>Assigning a different value which is out of the constraints</b>
     * Here it is -1
     * This is the simplest approach of the given problem.
     * The only thing we have to do is to assign a new value to each data of node in the linked list which is not in the range given.
     * Example suppose (1 <= Data on Node <= 10^3) then after visiting node assign the data as -1 as it is out of the given range.
     * Time complexity: O(n) Only one traversal of the loop is needed.
     * Auxiliary Space: O(1) There is no space required.
     * @param head The parameter is used to point at the head of a linked list
     * @return boolean returns the list actually contains a cycle(true) or not(false)
     */
    public static boolean method3(CLL.Node head) {
        if(head == null || head.next == null) return false;
        CLL.Node temp = head;
        while(temp != null) {
            if(temp.data == -1) return true;
            temp.data = -1;
            temp = temp.next;
        }
        return false;
    }

    /**
     * This method is called <b>Floyd’s Cycle-Finding Algorithm</b>
     * This is the fastest method and has been described below:
     * Traverse linked list using two pointers.
     * Move one pointer(slow) by one and another pointer(fast) by two.
     * If these pointers meet at the same node then there is a loop.
     * If pointers do not meet then linked list doesn’t have a loop.
     * Time complexity: O(n) Only one traversal of the loop is needed.
     * Auxiliary Space: O(1) There is no space required.
     * @param head The parameter is used to point at the head of a linked list
     * @return boolean returns the list actually contains a cycle(true) or not(false)
     */
    public static boolean method4(CLL.Node head) {
        if(head == null || head.next == null) return false;
        CLL.Node slow = head, fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        CLL cll = new CLL();
        cll.push(3);
        cll.push(5);
        cll.push(4);
        cll.push(1);
        cll.printList(cll.head);
        System.out.println(cll.size(cll.head));
        cll.link(1,cll.head);
        System.out.println(method2(cll.head));
    }
}
