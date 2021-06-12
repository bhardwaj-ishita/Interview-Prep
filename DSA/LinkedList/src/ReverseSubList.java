
/**
 * <h1>https://leetcode.com/problems/reverse-linked-list-ii/</h1>
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-12
 * */
public class ReverseSubList {

    private static boolean stop;
    private static SLL.Node left;

    public static void reverse(SLL.Node right, int l, int r) {
        if(r==1) return;
        right = right.next;


        if(l>1) left = left.next;
        System.out.println("BEFORE: right: " + right.data + " left: " + left.data);

        reverse(right,l-1,r-1);
        System.out.println("AFTER: right: " + right.data + " left: " + left.data);

        if(left == right || right.next == left) stop = true;

        if(!stop) {
            int t = right.data;
            right.data = left.data;
            left.data = t;

            left = left.next;
        }
    }

    /**
     * This method uses <b>Iterative link reversal</b>.
     * we move prev and curr to l until we've reached the required position
     * prev take cares for the node before curr
     * At this point we've reached lth node
     * we'll save con = prev and tail = curr
     * Now we move the rth node such that prev reaches rth node and curr to the next node until we've reached the required position
     * And while we are traversing we'll reverse the simultaneous link until we've reached the desired position
     * Now we'll link con to prev and tail to curr
     * Time Complexity: O(N) considering the list consists of NN nodes.
     * We process each of the nodes at most once (we don't process the nodes after the nth the node from the beginning.
     * Space Complexity: O(1) since we simply adjust some pointers in the original linked list and only use O(1) additional memory for achieving the final result.
     * @param head The parameter is used to point at the head of an input linked list
     * @param l the node at the left where we need to reverse the list
     * @param r the node at the right side of left node till where we need to reverse the list
     * @return SLL.Node sends the head of the list back
     */
    public static SLL.Node method1(SLL.Node head, int l,int r) {
        left = head;
        stop = false;
        reverse(head,l,r);
        return head;
    }

    public static SLL.Node method2(SLL.Node head, int l,int r) {
        SLL.Node con, tail, prev = null, curr = head, temp;
        while(l>1) {
            prev = curr;
            curr = curr.next;
            l--;
            r--;
        }
        con = prev;
        tail = curr;

        //0 because we want prev to reach rth node not curr
        while(r > 0) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            r--;
        }

        if(con != null) con.next= prev;
        else head = prev;

        tail.next = curr;
        return head;
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
        sll.printList(sll.head);
        sll.printList(method2(sll.head, 3,5));
    }
}
