import java.util.HashSet;

/**
 * <h1>Intersection of Two Linked Lists</h1>
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 *
 * It is guaranteed that there are no cycles anywhere in the entire linked structure.
 *
 * Note that the linked lists must retain their original structure after the function returns.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-12
 * */
public class Intersection {

    /**
     * In this method we use <b>hashing</b>
     * 1) Create an empty hash set.
     * 2) Traverse the first linked list and insert all nodes’ addresses in the hash set.
     * 3) Traverse the second list. For every node check if it is present in the hash set. If we find a node in the hash set, return the node.
     * This method required O(n) additional space and not very efficient if one list is large.
     * space complexity: O(n)
     * time complexity: O(n)
     * @param headA The parameter is used to point at the head of an the first input linked list;
     * @param headB The parameter is used to point at the head of an the first input linked list;
     * @return SLL.Node sends back the head of the list
     */
    public static SLL.Node method1(SLL.Node headA, SLL.Node headB) {
        SLL.Node listA = headA, listB = headB;
        HashSet<SLL.Node> hashSet  = new HashSet<>();
        while(listA != null || listB != null) {
            if(hashSet.contains(listA)) return listA;
            if(listA != null) {
                hashSet.add(listA);
                listA = listA.next;
            }
            if(hashSet.contains(listB)) return listB;
            if(listB != null) {
                hashSet.add(listB);
                listB = listB.next;
            }
        }

        return null;
    }

    /*Method:
    (Traverse both lists and compare addresses of last nodes)
    This method is only to detect if there is an intersection point or not.
    1
     \
      4-5-6    here the last node is same. Thus, if the last node of both lists are same then the list intersect
     /
    2
    1) Traverse the list 1, store the last node address
    2) Traverse the list 2, store the last node address.
    3) If nodes stored in 1 and 2 are same then they are intersecting.
    The time complexity of this method is O(m+n) and used Auxiliary space is O(1)*/

    /**
     * In this method we use <b>difference of node counts</b>
     * CASE1: length of both the lists are same
     *     if the intersection is at the 4th node of each list
     *     then during the 4th loop a != null --> a.next and b != null --> b.next
     *     hence both a and b will be at the same node a==b
     *     so the loop will terminate and return a
     *
     * CASE2: length is different
     *      if the length of both lists are different then there will be a point when a will reach the end of the list
     *      and b will still be traversing the list
     *      a == null --> headB && b != null --> b.next
     *      then a will start traversing listB
     *      then there will be a point when b == null --> headA && a != null --> a.next
     *      at this point a has covered x((length of listA and y-x)==length of listB) and have to cover
     *      at this point b has covered y(length of listB)
     *      and both have to travel the x(length of listA)
     *       in the second traversal, swapping a and b synchronizes a and b before the end of the second traversal.
     *       By synchronizing a and b I mean both have the same remaining steps in the second traversal so that it's
     *       guaranteed for them to reach the first intersection node, or reach null at the same time
     *       (technically speaking, in the same iteration)
     *
     * CASE3: there is no intersection
     *      if there is no intersection and length is same a and b will reach the null in the first iteration
     *      and at the same time
     *      or else if the length is not same then they'll reach null at the end of second iteration
     *
     * space complexity: O(1)
     * time complexity: O(n+m)
     * @param headA The parameter is used to point at the head of an the first input linked list;
     * @param headB The parameter is used to point at the head of an the first input linked list;
     * @return SLL.Node sends back the head of the list
     */
    public static SLL.Node method2(SLL.Node headA, SLL.Node headB) {
        SLL.Node a = headA, b = headB;
        while(a!=b) {
            a = a==null ? headB : a.next;
            b = b==null ? headA : b.next;
        }
        return a;
    }


    public static void intersect(SLL.Node temp1, SLL.Node temp2, int pos1, int pos2) {
        SLL.Node head2 = temp1, head1 = temp2;
        while(head1.next != null && --pos1>0) {
            head1 = head1.next;
        }
        while(head2.next != null && --pos2>0) {
            head2 = head2.next;
        }
        head1.next = head2;
    }

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        SLL sll1 = new SLL();
        SLL sll2 = new SLL();

        sll1.push(3);
        sll1.push(5);
        sll1.push(4);
        sll1.push(3);
        sll1.push(2);

        sll2.push(6);
        sll2.push(1);

        int pos1 = 2; int pos2 = 3;

        intersect(sll1.head, sll2.head, pos1, pos2);
        sll1.printList(sll1.head);
        sll2.printList(sll2.head);
        System.out.println(method2(sll1.head, sll2.head).data);
    }
}
