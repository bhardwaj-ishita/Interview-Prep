public class CLL {
    Node head;

    static class Node{
        Node next;
        int data;

        Node() {next = null;}

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    int size(Node head) {
        if(head == null) return 0;
        if(head.next == null) return 1;
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size += 1;
            temp = temp.next;
        }
        return size;
    }

    void push(int newData) {
        Node newNode = new Node(newData);
        Node temp = head;
        newNode.next = head;
        head = newNode;
        System.out.println(newData + " pushed");
    }

    void printList(Node head) {
        if(head == null)
            return;

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void link(int pos, Node head) {
        if(pos == -1) {
            System.out.println("No link needed");
            return;
        }
        Node temp = head;
        Node tail = head;
        for(int i = 0; i < pos; i++) temp = temp.next;
        while(tail.next != null) tail = tail.next;
        tail.next = temp;
        System.out.println("tail: " + tail.data + " link: " + temp.data);
        System.out.println("List is linked at index " + pos);
    }

    public static void main(String[] args) {
        CLL cll = new CLL();
        cll.push(3);
        cll.push(5);
        cll.push(4);
        cll.push(1);
        cll.printList(cll.head);
        System.out.println(cll.size(cll.head));
        cll.link(1,cll.head);
    }

}
