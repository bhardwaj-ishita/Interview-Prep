public class SLL {
    Node head;

    static class Node {
        //a node consist of
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    boolean isEmpty(SLL sll) {
        if(head == null) {
            return true;
        }
        else return false;
    }

    void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
        System.out.println("Pushed " + newData);
    }

    void deleteNode(int key) {
        Node temp = head, prev = null;
        if(isEmpty(this))
            return;
        while(temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if(temp == null)
            return;

        prev.next = temp.next;
        System.out.println("Deleted " + key);
    }

    void printList(Node head) {
        if(isEmpty(this))
            return;

        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SLL sll = new SLL();

        System.out.println(sll.isEmpty(sll));
        sll.push(3);
        System.out.println(sll.isEmpty(sll));
        System.out.println(sll.head.data);
        sll.push(5);
        sll.push(9);
        sll.push(1);
        sll.push(43);

        sll.printList(sll.head);
        sll.deleteNode(6);
        sll.deleteNode(1);
        sll.printList(sll.head);

    }
}

