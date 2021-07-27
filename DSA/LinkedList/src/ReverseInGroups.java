import java.util.Stack;

public class ReverseInGroups {
    //push the first k nodes
    //reverse them
    //and then push the next k nodes
    //connect it with the previous and reverse them
    //so on until the list is finished
    public static SLL.Node reverse(SLL.Node head, int k)
    {
        Stack<SLL.Node> s = new Stack<>();
        SLL.Node temp = head;
        SLL.Node prev = null;
        while(temp!=null) {
            int count = 0;
            while(temp!=null && count < k) {
                s.push(temp);
                temp = temp.next;
                count++;
            }

            while(!s.isEmpty()) {

                if(prev==null) {
                    //to assign the final head once
                    prev = s.peek();
                    head = prev;
                    s.pop();
                }
                else {
                    //all the else time this block will be followed
                    prev.next = s.peek();
                    prev = prev.next;
                    s.pop();
                }
            }
        }
        prev.next = null;
        return head;
    }
}
