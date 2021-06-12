# list:

List is an *abstract data type*
It is an interface (java.util.list)

Abstract data types:
1. not a concrete data structure
2. doesn't tell how data is organized

interface  LIST
implementation **arraylist, linkedlist**

##### JDK LinkedList

-doubly linked list
-not synchronized (Collections.synchronizedList() to synchronize it when initialized) to prevent unsynchronized access
-LinkedList<something> list = new LinkedList<>();
-addFirst() to add to the front

```java
Iterator iter = list.iterator();//iterator class
while(iter.hasNext()) {Sout(liter.next());}
```

-add() or addLast() adds item at the tail/end
-inherits from AbstractSequentialList
-nothing backs it as it itself is a Data Structure
-removeFirst() and removeLast()
-if memory is not tight then use linked list
-any operation done on null will result in a NullPointerException

### Linked list v/s Arrays

1. size: 

   -arrays stored in contiguous blocks of memory. size can't be altered due to risk of overwriting over other date

   -linked list have each node pointing out to the next one. hence data can exist at scattered addresses

2. memory allocation:

   -for arrays at compile time

   -for linked list at runtime

3. memory efficiency:

   -linked lists use more memory as a reference to the next node is also stored along with the data. although in front of size flexibility it is a very negligible problem. linked lists are very helpful when there is uncertainty about size or very large variations in size of data elements. they can increase size step by step proportionately to the amount of data 

   -for arrays memory equivalent to the upper limit on the size must be used even when not all of it is being used

4. execution time:

   -in arrays, elements can be directly accessed with its index. better cache locality improves performance, hence some operations like modifying certain elements is faster in arrays

   -in linked list, all previous elements must be traversed to reach any element. whereas inserting/ deleting elements are faster in linked list.

### Why favor linked lists?

1. size of array fixed (hence need to know the size in advance) and allocated memory to the arrays is fixed to the upper limit irrespective of usage (the upper limit is rarely reached)
2. insertion in array is expensive as a room for the new element has to be created and existing elements have to be shifted
3. linked list hence has dynamic size and ease of insertion/deletion

### Linked List drawbacks:

1. random access not allowed. have to access sequentially. hence no binary search with linked list
2. extra memory for the pointer with each element
3. arrays have better cache locality which makes a pretty big difference in performance.

### Array List:

it can dynamically be resized

```java
ArrayList<Integer> grades = new ArrayList<Integer>();
```

Integer : a class is expected; it is a wrapper around integer data type
<> put a type in this

```java
grades.add(5); //value is added
//to put values in an arraylist
```

```java
grades.get(0); //index is added
//to get the value at any index
```

```java
grades.set(0,10); //index,value
//to put a certain value at a specific index
```

```java
grades.size(); //to know how many elements are in the array

//the add interface workings
private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)  //see's if the size full
            elementData = grow();       //if yes then grow the capacity of the list
        elementData[s] = e;             //then add the object
        size = s + 1;                   //increment the size
    }
```

### Singly Linked List:

![image-20210428165832118](C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210428165832118.png)

-each item is called *NODE*
-first node is *HEAD* of the list
-And the last item is a *NULL NODE*
-if linked list is empty then the value of the head is NULL

-each item is aware of next item in list
-a node stores **integer value **(data) and **reference to the next integer **(pointer or reference to the next node) in the list
-different from arrays: in arrays elements are completely unaware of each other

-you should know the first node and then iterate to the next
stop the iterator when reached null

-in C and C++ linked list can be made using struct, whereas in java and C# it has a separate class and node as a separate class

###### >Class linked list has a reference to the node class

```java
class LinkedList{
	Node head; //made an object of Node named head
	//head of the list
	
	class Node{
		int data;//the date 
		Node next;//pointer
        //next by default initialized as null
        
        //constructor to create a new node
        Node(int data) {
            this.data = data;
        }
	}
}
```

###### >Singly linked list with 3 nodes

-->made the linked list head
-->created nodes
-->added the date
-->linked them to each other

we declared the head. then we made all these nodes. The last node we added was by default connected to the next null node. hence the only nodes left to be linked are the head to all other full nodes till the last node before null.

```java
class LinkedList {
    Node head;
    
    class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            next = null;
        }
    }
    
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        
        llist.head = new Node(1);//made the head
        Node second = new Node(2);
        Node third = new Node(3);
        //three nodes have been allocated dynamically
        //and we have referenced them as head, first
        //and second
        
        //we have put the data but the pointer is not 
        //made yet
        
        llist.head.next = second;
        second.next = third;
        //we have linked the nodes with each other now
    }
}
```

<img src="C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210428172359631.png" alt="image-20210428172359631" style="zoom:50%;" />



###### >Traversal of the Singly Linked List (basically creating the print list method)

```java
class Linked List{
	Node head;
	
	static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            next = null;
        }
	}
    
    public void printList() {
        Node n = head;
        while(n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
    
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        
        llist.head.next = second;
        second.next = third;
        
        llist.printList();
    }
}
```

OUTPUT:

![image-20210428185954868](C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210428185954868.png)

###### >Deleting a given key and Push a node in front and size

-->need to delete node x
-->find it's previous node
-->break their link and join it with the next node of x
-->free memory for the node to be deleted

<img src="C:\Users\ishit\Downloads\WhatsApp Image 2021-04-28 at 6.08.42 PM.jpeg" style="zoom: 33%;" />



```java
class LinkedList {
    Node head;
    int size;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    void printList() {
        Node n = head;
        while(n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    void deleteNode(int key) {
        //here the key is the data
        Node temp = head, prev = null;

        //first we'll check the head
        if(temp != null && temp.data == key) {
            head = temp.next;
            return;
            //deleting head simply means giving the
            //head position to the next node because
            //head is only connected to head.next and
            //now we've removed it's existence
        }

        //if it isn't head then we'll check all the
        //other nodes - null
        while(temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        //if none of the nodes have the key and we've
        //come to the end i.e. Null then we'll return
        if(temp == null) {
            return;
        }

        //if we've found the node then we'll unlink it
        prev.next = temp.next;
        //prev < prev.next == temp < temp.next
        size--;
    }

    //adding anything before the head makes that new
    //"anything" the new head
    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void isEmpty(int size) {
        if(size == 0) {
            System.out.println("True");
        }
        else
            System.out.println("False");
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        llist.push(6);
        llist.push(1);
        llist.push(5);
        llist.push(2);
        llist.push(4);

        System.out.print("Created list: ");
        llist.printList();

        llist.deleteNode(1);

        System.out.print("\nList after deletion: ");
        llist.printList();

        System.out.println("\nSize of the list is: " + llist.size);

    }

}
```

OUTPUT:

![image-20210428191011195](C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210428191011195.png)



###### >Rough Notes:

-to create a new node as head

1. create a new node "Bill"
2. assign "Jane" to the next field
3. Assign head to "Bill"
it is O(1) time complexity: doesn't matter how many items are there in the list
we are going to do same number of steps for each item in the list

-to delete the head node
1. Assign "Bill" to a temp variable "removeNode"
2. assign head to "Jane" hence automatically removed Bill
3. return "removeNode"
Or can point the reference of Bill to null
O(1) time complexity

use liked list whenever we want to insert or remove items in the front of the list
it grows without resizing it
if memory of your computer is tight then it might be a problem
only bounded by the memory you have
you have to store the extra field i.e. null field with every value

> - [x] addToFront();
> - [x] printList();
> - [x] size();
> - [x] isEmpty();
> - [x] removeItem();

### Doubly Linked List (DLL):

![image-20210429185953464](C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210429185953464.png)

each node points to next and previous item in list

it has a head pointer and a tail pointer and both connected to the nextNode and null.

prefer doubly linked list when playing with nodes at the front or the back only because if you want to play with the middle nodes it will loose the advantage of a linked list i.e. to addToFront or addToBack.

Time complexity to insertion of a node at front or back is O(1)

```java
class DDL {
    Node head;
    
    static class Node {
        int data;
        Node next;
        Node prev;
        
        Node(int data) {
            this.data = date;
        }
    }
}
```

##### >Advantages over singly linked list:

1. can be traversed both the sides
2. deletion/insertion more efficient if pointer given

##### >Disadvantages over singly linked list:

1. require extra space as info of next and previous both are saved

#### Insertions

##### >Insert  at head:

-create new node
-new.next = head
-new.back = head.back
-head.back = new
-head = new

```java
//add to the front
void push(int key) {
    Node newNode = new Node(key);
    newNode.prev = null;
    newNode.next = head;

    //there is a possibility that the list is empty
    if(head != null)
        head.prev = newNode;

    head = newNode;
}
```



##### >Insert at tail

-create new node
-new.next = tail.next
-new.back = tail
-tail.next = new
-tail = new

```java
//add node at the end
void append(int key) {
    Node newNode = new Node(key);
    Node last = head;
    newNode.next = null;

    //if the list is empty then the newNode is the head
    if(head == null) {
        head = newNode;
        newNode.prev = null;
        return;
    }

    while(last.next != null) {
        last = last.next;
    }

    last.next = newNode;
    newNode.prev = last;
}
```



##### >Inserting node A between B and C

-a.next = c = b.next
-a.back = c.back
-b.next = a
-c.back = a

insertion is a O(1) but to find the insertion position it will take worst case O(n)

```java
//insert after a given node
void insertAfter(Node prevNode, int key) {
    if(prevNode == null) {
        System.out.println("Previous node can't NULL ");
        return;
    }
    Node newNode = new Node(key);
    newNode.next = prevNode.next;
    newNode.prev = prevNode;
    prevNode.next = newNode;

    //if the prevNode is the last node in the list then it's next will be null and null has no link to the previous node
    if(newNode.next != null)
        newNode.next.prev = newNode;
}
```



#### Deletions

##### >Deleting from head

-removeNode = head
-head.next.back = head.back
-head = head.next

##### >Delete from tail

-removeNode = tail
-tail.back.next = tail.next
-tail = tail.back

##### >Remove node A from between B and C

-removeNode = a
-b.next = c =a.next
-c.back = a.back = b

```java
void deleteNode(Node del) {
    //base case (from tail)
    if(head == null || del == null)
        return;
    
    //from head
    if(del == head) {
        head = del.next;
        head.prev = null;
        return;
    }
    
    //from between
    //only if prev and next of del are not null
    if(del.next != null) {
         del.next.prev = del.prev;
    }
    
    if(del.prev != null) {
         del.prev.next = del.next;
    }
    
    //to free the memory upholded by del
    return;
}
```

deletion is a O(1) but to find the insertion position it will take worst case O(n)

####  Complete working program:

```java
public class DLL {
    Node head;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    //add to the front
    void push(int key) {
        Node newNode = new Node(key);
        newNode.prev = null;
        newNode.next = head;

        if(head != null)
            head.prev = newNode;

        head = newNode;
    }

    //insert after a given node
    void insertAfter(Node prevNode, int key) {
        if(prevNode == null) {
            System.out.println("Previous node can't NULL ");
            return;
        }
        Node newNode = new Node(key);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next = newNode;

        if(newNode.next != null)
            newNode.next.prev = newNode;
    }

    //add node at the end
    void append(int key) {
        Node newNode = new Node(key);
        Node last = head;
        newNode.next = null;

        if(head == null) {
            head = newNode;
            newNode.prev = null;
            return;
        }

        while(last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.prev = last;
    }

    //prints list from the given node
    void printList(Node node) {
        Node last = null;
        System.out.println("Traversal in forward direction: ");
        while(node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }

        System.out.println();
        System.out.println("Traversal in reverse direction");
        while(last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }

    //delete nodes
    void deleteNode(Node del) {
        //base case (from tail)
        if(head == null || del == null)
            return;

        //from head
        if(del == head) {
            head = del.next;
            head.prev = null;
            return;
        }

        //from between
        //only if prev and next of del are not null
        if(del.next != null) {
            del.next.prev = del.prev;
        }

        if(del.prev != null) {
            del.prev.next = del.next;
        }
    }

    public static void main(String[] args) {
        DLL dll = new DLL();

        dll.append(6);
        dll.push(7);
        dll.push(1);
        dll.append(4);
        dll.insertAfter(dll.head.next, 8);

        System.out.println("Created DLL is: ");
        dll.printList(dll.head);
        System.out.println();

        dll.deleteNode(dll.head.next.next);
        System.out.println("after deleteing middle node: ");
        dll.printList(dll.head);
        System.out.println();

        dll.deleteNode(dll.head);
        System.out.println("after deleteing head node: ");
        dll.printList(dll.head);

    }
}
```

OUTPUT:

![image-20210429181949386](C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210429181949386.png)



### Circular Linked List:

all nodes are connected

there is no null at the end

CLL can be SLL or DLL

##### Advantages of CLL

1. any node can be starting point. we just have to stop when the first node is visited again
2. used for queue. don't have to maintain two pointers. can maintain pointer at the last and first = last.next
3. CLL are used to repeatedly go around the list
4. used for implementing adv structures like fibonacci heap

##### Insertion: 

![image-20210429190105131](C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210429190105131.png)

-->last.next = first

as we add nodes we move to the last node and keep the pointer at the latest added node. it will make traversal easier. because if we keep the node at the beginning we'll have to traverse all the way. so insertion in the beginning or the end takes constant time irrespective of length

kinds of insertion

###### -in empty list

```java
Node toEmpty(Node last, int data) {
    //if the last node is not null then it means the list isn't empty
    if(last != null) {
        return last;
    }
    
    Node temp = new Node(data);
    last = temp;
    temp.next = last;
    //we linked the single node to itself to make a circular linked list
    
    return last;
}
```

###### -at the beginning

```java
Node toBeginning(Node last, int data) {
    //if the last is null i.e. LL is empty
    if(last == null){
        return toEmpty(last,data);
    }
    
    Node temp = new Node(data);
    temp.next = last.next;
    last.next = temp;
    
    return last;
}
```

###### -at the end

```java
Node toEnd(Node last, int data) {
    if(last == null) {
        return toEmpty(last,data);
    }
    
    Node temp = new Node(data);
    temp.next = last.next;
    last.next = temp;
    last = temp;
    
    return last;
}
```

###### -in between nodes

```java
//item is the date next to which the new input data needs to be added
Node addAfter(Node last, int data, int item) {
    if(last == null) {
        return last;
    }
    
    Node temp = new Node(data);
    Node first = last.next;
    
    //find the node next to which the new node will be made
    
    //do-while iterates atleast one loop and then looks at the condition
    do{
        if(first.data == item) {
            temp.next = first.next;
            first.next = temp;
            
            if(first == last)
                last = temp;
            
            return last;
        }
        first = first.next//iterator
    }
    while(first != last.next)
        
    //if the loops complete and can't find the item
    System.out.println(item + "not present in the list.")
        return last;
    
}
```



##### Traversal:

```java
void printList(Node last){
    if(last == null) {
        System.out.println("The list is empty");
        return;
    }
    
    //first node
    Node temp = last.next;
    
    
    do{
        System.out.print(temp.dat + " ");
        temp = temp.next;
    }
    while(temp != last.next);
    
}
```

##### Complete working program:

```java
public class CLL {
    private static Node last;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node toEmpty(Node last, int data) {
        if(last != null) {
            //the list isn't empty
            return last;
        }

        Node temp = new Node(data);
        temp.next = temp;
        last = temp;
        return last;
    }

    static Node toBeginning(Node last, int data) {
        if(last == null) {
            //the list is empty
            return toEmpty(last,data);
        }

        Node temp = new Node(data);
        temp.next = last.next;
        last.next = temp;

        return last;
    }

    static Node toEnd(Node last, int data) {
        if(last == null) {
            //the list is empty
            return toEmpty(last,data);
        }

        Node temp = new Node(data);
        temp.next = last.next;
        last.next = temp;
        last = temp;

        return last;
    }

    static Node addAfter(Node last, int data, int item) {
        if(last == null) {
            return last;
        }

        Node temp = new Node(data);
        Node first = last.next;

        do{
            if(first.data == item) {
                temp.next = first.next;
                first.next = temp;

                if(first == last) {
                    last = temp;
                }
                return last;
            }
            first = first.next;
        }
        while(first != last.next);

        System.out.println(item + " is not present in the list.");
        return last;
    }

    static void printList(Node last) {
        if(last == null) {
            System.out.println("list is empty");
            return;
        }

        Node first = last.next;
        do{
            System.out.print(first.data + " ");
            first = first.next;
        }
        while(first != last.next);
    }

    public static void main(String[] args) {
        Node last = null;

        last = toEmpty(null,6);
        last = toBeginning(last,4);
        last = toBeginning(last, 2);
        last = toEnd(last,8);
        last = toEnd(last,12);
        last = addAfter(last,10,8);

        printList(last);
    }
}
```

OUTPUT:

![image-20210430184224259](C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210430184224259.png)

