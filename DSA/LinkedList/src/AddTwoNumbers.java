public class AddTwoNumbers {
    public SLL.Node addTwoNumbers(SLL.Node l1, SLL.Node l2) {
        int carry = 0;
        SLL.Node head = new SLL.Node(0);
        SLL.Node ans = head;
        while(l1 != null || l2 != null) {
            int x = (l1 != null)? l1.data : 0;
            int y = (l2 != null)? l2.data : 0;
            int sum = carry + x + y;
            carry = sum/10;
            int value = sum%10;
            ans.next = new SLL.Node(value);
            ans = ans.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
            //System.out.println("carry: " + carry + " value: " + value);
        }

        //System.out.println("out");

        if(carry > 0) ans.next = new SLL.Node(carry);

        return head.next;

    }
}
