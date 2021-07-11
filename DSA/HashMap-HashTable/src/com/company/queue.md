# queue:

-a linear structure which follows a particular order in which operations are performed

-First In First Out order

-difference between stack and queue is in removing (stacks: item added recently removed first; queue: item added first removed first)

-used in breadth first search

![image-20210514200758364](C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210514200758364.png)

### -operations:

1. enqueue - adds item to the end; if queue full then 'overflow condition'
2. dequeue - removes item from the front; items popped in the same order in which they are pushed; if queue empty then 'underflow condition'
3. front - get front item from queue
4. rear - get last item from queue

### array implementation of queue:

-keep track of two indices: front and rear

-enqueue(add) an item at the rear

-dequeue(remove) an item from the front

#####  >isFull

looks if the size of the queue at present is equal to the total capacity of the queue when initialized

queue.size = queue.capacity

##### >isEmpty

looks if the size of the queue is zero

queue.size == 0;

#####  >enqueue

we are adding an item to the rear of the queue

-first check if the queue is full
-if full then return 
-if not full: increase the size
-then at that index add the item
-then put the rear pointer at that index

```java
class Queue {
    int front, rear, size;
    int capacity;
    int array[];//act as a queue
    
    public Queue(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        array = new int[this.capacity];
    }
    
    //isFull when size of the queue is equal to capacity
    boolean isFull(Queue queue) {
        return(queue.size == queue.capacity);
    }
    
    //isEmpty when size is zero
    boolean isEmpty(Queue queue) {
        return (queue.size == 0);
    }
    
    //enqueue when adding an item to the end of the queue
    void enqueue(int item) {
        if(isFull(this))
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to queue");
    }
    
    //dequeue when removing an item from the front of queue
    void dequeue() {
        if(isEmpty(this))
            return;
        int item =  this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        System.out.println(item + " dequeued out of queue");
    }
    
    //front when want the front item of the queue
    int front() {
        if(isEmpty(this))
            return Integer.MIN_VALUE;
        
        return this.array[this.front];
    }
    
    //rear when want the rear item of the queue
    int rear() {
        if(isFull(this))
            return Integer.MIN_VALUE;
        
        return this.array[this.rear];
    }
    
    public static void main(String[] args) {
        Queue queue = new Queue(1000);
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        
        queue.dequeu();
        
        System.out.println(queue.front() + " is the front item");
        System.out.println(queue.rear() + " is the rear item"); 
    }
}
```

OUTPUT:

```
Operations              Complexity
Enque(insertion)           O(1)
Deque(deletion)            O(1)
Front(Get front)           O(1)
Rear(Get Rear)             O(1)

Auxiliary Space: O(N). 
N is the size of array for storing elements.
```

### advantages and disadvantages:

-it is easy to implement

-it is a static data structure and have a fixed size
-if queue has a very large size then we might not be able to hold enqueue and dequeue operations even when we might have an empty queue (this problem is solved by using circular queue)

### priority queue:

-an extension of queue
-every item has a priority associated with it
-high priority --> dequeue first
-if two items have same priority then priorities further according to their order in the queue

-can use arrays or linked lists for this implementation. writing the getHighestPriority() and deleteHighestPriority() methods would be easy in LL
-LL and arrays give O(n) time
-heap is generally prefferred for priority queue because they provide better performance

functions: add O(log n), remove O(log n), peek O(1)

heap by default put the smallest value as higher priority

the order in which you put it it, doesn’t stay like that just like hash map

small value higher priority (Rank List) and larger value higher priority (Score list)

High priority will be removed first

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
//By default puts smaller values at higher priority

PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//Puts larger values at higher priority
```



#### difference between heap and priority queue:

priority queue is an abstract datatype. And heap is a data structure

We can say that heap happens to be  a very good data structure to implement a priority queue because operations which are made efficient by the heap data structure are the operations that the priority queue interface needs



Heaps are represented using arrays(usually) and can get maximum(or highest priority) element in O(1).
The Heaps are visualized as a binary tree, with elements stored internally in an array. So the element with the highest priority is always the root, which makes the getMax() operation of O(1).

![98](C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210627154914653.png)

#### difference in basic operations of priority queue:

The **remove**() and **poll**() methods differ only in their behavior when the **queue** is empty: the **remove**() method throws an exception, while the **poll**() method returns null. 

The element() and peek() methods return, but do not **remove**, the head of the **queue**.

### heap:

##### to heapify an array:

root [0]
left child of i^th^ node [2xi + 1]
right child of i^th^ node [2xi + 2]
parent of i^th^ node [(i-1)/2]

##### time complexity:

to heapify a node it takes O(log n) 

to heapify n nodes it will take O(n log n)

add() and poll(): O(log n)

toArray() and contains(): O(n)

peek() and size() and IsEmpty() : O(1)

##### when we poll() we heapify_down()  

when we poll() we are basically removing the root and putting the last number in the array in it’s place. Hence we have to heapify it from top to bottom i.e. now it is the root and we’ll have to compare it to its child nodes

##### when we add() we heapify_up()

 when we add() we are basically adding a new element at the end of the already heapified array. hence the leaf node needs to be heapify from bottom to top i.e it needs to be compared to it’s parent node

##### max heap 

A[parent(i)] > A[i]

##### min heap

 A[parent(i)] < A[i]



### deque:

