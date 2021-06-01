/**
 * <h1>Merge Two Sorted Lists</h1>
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-1
 * */
public class MergeTwoLists {

    /**
     * This is an <b>Iterative</b> method
     * This is also an in-place method
     *
     * We have a method 2 whose only function is to decide the head of the list and
     * then send the head and the other list as merge(head, the other list)
     *
     * In method merge, we get as parameters the head = l1 and other list = l2
     * The corner case here is if l1 has only 1 node then directly attach the end to the head of the other node
     *
     * We make pointers curr and next for both the lists
     * And use a while loop until we've reached either end of the list
     *
     * If the curr2 lies between curr1 and next1 like (curr1 --> curr2 --> next1)
     * then align them in exactly that way and move curr1 and curr2 pointers ahead
     * Also assign the next2 pointer here
     *
     * Else if the the above situation is not true (curr1 --> next1 --> curr2 --> randomNode)
     * we'll move the curr1 and next1 pointers further
     * such that now the situation is (AnotherRandomNode --> curr1 --> curr2 --> next1)
     *
     * Or if the list one is finished in this situation like (curr1 --> next1 --> null)
     * join the curr2 next to the next1 node and return the head = l1 (curr1 --> next1 --> curr2 --> null)
     *
     * Take care of few base conditions and corner cases like:
     * if a list is null then return the other list is at the answer
     * and if both lists are null then return null
     *
     * space complexity: O(1) -->  As there is no space required
     * time complexity: O(n) --> Only one traversal of the linked lists are needed.
     * @param l1 The parameter is used to point at the head of the first sorted linked list
     * @param l2 The parameter is used to point at the head of the second sorted linked list
     * @return SLL.Node returns the head pointer of the sorted and merged linked list.
     */

    public static SLL.Node merge(SLL.Node l1, SLL.Node l2) {
        if(l1.next == null) {
            l1.next = l2;
            return l1;
        }

        SLL.Node curr1 = l1, next1 = l1.next;
        SLL.Node curr2 = l2, next2 = l2.next;
        while(next1 != null && next2 != null) {
            //pointers in the list 2 are traversing forward here
            if(curr1.data <= curr2.data && next1.data >=  curr2.data) {
                next2 = curr2.next;
                curr1.next = curr2;
                curr2.next = next1;
                curr1 = curr2;
                curr2 = next2;
            }
            else {
                //list 2 pointers are getting further here as the nodes in list1 are still left
                if(next1.next != null) {
                    curr1 = curr1.next;
                    next1 = next1.next;
                }
                //here the first list has probably come to an end
                else {
                    next1.next = curr2;
                    return l1;
                }
            }
        }
        return l1;
    }

    public static SLL.Node method1(SLL.Node l1, SLL.Node l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        return merge((l1.data < l2.data) ? l1 : l2, (l1.data < l2.data) ? l2 : l1);
        //till here we've sent the smaller head node as l1 and other as l2
    }

    /**
     * This method uses <b>Recursion</b>
     * This is an in-place method
     *
     * Compare the heads of both the link to find the head of the final sorted and merged list
     * Then start comparing the nodes of both the lists simultaneously
     * If a is smaller, then a.next will be seen by sending a.next and b as parameters for recursion
     *
     * Take care of few base conditions and corner cases like:
     * if a list is null then return the other list is at the answer
     * and if both lists are null then return null
     *
     * time complexity: O(n) --> Only one traversal of the linked lists are needed.
     * space complexity: O(n) --> If the recursive stack space is taken into consideration.
     * @param l1 The parameter is used to point at the head of the first sorted linked list
     * @param l2 The parameter is used to point at the head of the second sorted linked list
     * @return SLL.Node returns the head pointer of the sorted and merged linked list.
     */
    public static SLL.Node method2(SLL.Node l1, SLL.Node l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        SLL.Node head, right = l2, left = l1;
        head = (right.data <= left.data) ? right: left;
        if(right.data <= left.data) right.next = method2(right.next, left);
        else if(right.data > left.data) left.next = method2(right, left.next);
        return head;
    }

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        SLL l1 = new SLL();
        SLL l2 = new SLL();

        l1.push(5);
        l1.push(3);
        l1.push(2);

        l2.push(4);
        l2.push(3);
        l2.push(1);

        SLL.Node head = method2(l1.head,l2.head);

        l1.printList(head);
    }
}
