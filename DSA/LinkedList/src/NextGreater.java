import java.util.Arrays;
import java.util.Stack;

/**
 * <h1>Next Greater Node In Linked List</h1>
 * https://leetcode.com/problems/next-greater-node-in-linked-list/
 *
 * We are given a linked list with head as the first node.
 * Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
 *
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i,
 * node_j.val > node_i.val, and j is the smallest possible choice.
 * If such a j does not exist, the next larger value is 0.
 *
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 *
 * Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of
 * a linked list with a head node value of 2, second node value of 1, and third node value of 5.
 *
 * @author Ishita Bhardwaj
 * @version 11.01
 * @since   2021-06-4
 * */
public class NextGreater {

    /**
     * This is a <b>Naive Method</b>.
     * Here we uses two loops to itterate the head and another tp compare all the node.data with the head pointer to find the next greater value
     * space complexity: O(n)
     * time complexity: O(n^2)
     * @param head The parameter is used to point at the head of an input linked list
     * @return int[] This array gives all the next greater values respectively with all the node position
     */
    public static int[] method1(SLL.Node head) {
        int size = 0;
        SLL.Node temp = head;
        while(temp !=null) {
            temp = temp.next;
            size++;
        }
        int i = 0;
        boolean got = false;
        int[] answer = new int[size];
        SLL.Node big;
        while(temp!=null) {
            big = temp;
            while(big !=null) {
                if(big.data > temp.data) {
                    got = true;
                    answer[i++] = big.data;
                    break;
                }
                big = big.next;
            }
            if(!got) answer[i++] = 0;
            got = false;
            temp = temp.next;
        }
        return answer;
    }

    /**
     * This method uses <b>Stack</b>.
     * Instead of traversing all the way over and over
     * We'll save the values side by side in the stack in the reverse order and traverse the list in reverse too once only
     * If the pointer value is greater then pop the stack until a value greater then pointer is achieved
     * If such value is not achieved then assign the pointer 0
     * space complexity: O(n)
     * time complexity: O(n)
     * @param head The parameter is used to point at the head of an input linked list
     * @return int[] This array gives all the next greater values respectively with all the node position
     */
    public static int[] method2(SLL.Node head) {
        int size = 0;
        SLL.Node temp = head;
        while(temp != null) {
            temp = temp.next;
            size++;
        }

        int i = size - 1;
        int[] a = new int[size];
        if(head.next == null)  {
            a[i] = 0;
            return a;
        }

        head = ReverseLL.method2(head);
        Stack<Integer> s = new Stack<Integer>();
        while(head != null && i >= 0) {
            while(!s.empty() && s.peek() <= head.data) s.pop();
            if(s.empty()) {
                a[i] = 0;
                s.push(head.data);
                i--;
            }
            else if(!s.empty() && s.peek() > head.data) {
                a[i] = s.peek();
                s.push(head.data);
                i--;
            }
            head = head.next;
        }
        return a;
    }

    /**
     * This is the main method which makes use of addNum method.
     * @param args Unused.
     */
    public static void main(String[] args) {
        SLL sll = new SLL();

        sll.push(1);
        sll.push(5);
        sll.push(2);
        sll.push(9);
        sll.push(1);
        sll.push(5);
        sll.push(7);
        sll.push(1);
        System.out.println(Arrays.toString(method2(sll.head)));
    }
}
