# stacks:

tells What operations we can do on the item 

but doesn't tell how the data needs to be stored

stack is backed by many data structures like arrays and linked lists. (backed means these DS are used to build stack)

ideal data structure is singly linked list 
addToFront() - push
removeFront() - pop
node.val - peek

an Abstract data type:

1. not a concrete data structure
2. doesn't tell how data is organized

features:
-LIFO, last item stored in the stack is taken out first; Last in, first out. (no random access)
-push (add items to the stack) if stack full then it is an overflow situation
-pop (remove item to the stack) if stack is empty then it is an underflow situation
-peek (gets the top item without popping)
-isEmpty (returns true if stack is empty else false)

time complexity: depends on the DS backing it (SLL is  O(1); array is O(n))

use array: if max number of items on the stack or if memory is tight

### Stacks implementation backed by Arrays:

Pros: 
-easy to implement. 
-Memory is saved as pointers not involved

Cons:
-not dynamic
-doesn't grow or shrink depending on needs at runtime

```java
public class Stack {
    static final int MAX = 1000;//a static value of the stack
    int top;//pointer to the index at the top
    int[] a = new int[MAX];//maximum size of the Stack

    //Stack constructor
    Stack() {
        top = -1;
    }

    //IS EMPTY
    boolean isEmpty() {
        return (top < 0);
    }

    //PUSH
    void push(int val) {
        if(top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
        }
        else {
            //stacks will start adding at index 1
            a[++top] = val;
            System.out.println(val + " is pushed into stack");
        }
    }

    //POP
    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            //the index of top has
            //decremented as the initial top is popped
            return a[top--];
            //now the value at top is this
        }
    }

    //PEEK
    int peek() {
        if(top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else {
            int val = a[top];
            System.out.print("Top element is: ");
            return val;
        }
    }

    //Traverse stack
    void printStack() {
        if(top < 0) {
            System.out.println("Stack Underflow");
        }
        else {
            int iter = top;
            System.out.print("Elements present in stack: ");
            while(iter >= 0) {
                System.out.print(a[iter] + " ");
                iter--;
            }
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " is popped from the stack");
        System.out.println("Is the stack empty: " + s.isEmpty());
        System.out.println(s.peek());
        s.printStack();
    }
}
```

OUTPUT:

![image-20210502215239488](C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210502215239488.png)

### Stacks implementation backed by Linked List:

Pros: 
-can grow and shrink according to the needs at runtime

Cons:
-requires extra memory due to involvement of pointers

```java
class StackLL {
    StackNode root;//pointer to the top of the stack
    
    static class StackNode {
        int data;
        StackNode next;
        
        StackNode(int data) {
            this.data = data;
        }
        
        public boolean isEmpty() {
            if (root == null)
                return true;
            else
                return false;
        }
        
        void push(int data) {
			StackNode newNode = new StackNode(data);
            if(root == null)
                root = newNode;
            else {
                StackNode temp = root;
                root = newNode;
                newNode.next = temp;
                //exchanged the newNode and root 
            }
            System.out.println(data + " pushed to stack");
        }
        
        int pop() {
            int popped = Integer.MIN_VALUE;
            if(root == null)
                System.out.println("Stack is empty");
            else {
                popped = root.data;
                root = root.next;
            }
            return popped;
        }
        
        int peek() {
            if(root == null){
                 System.out.println("Stack is empty");
                return Integer.MIN_VALUE;
            }
               
            else {
                return root.data;
            }
        }
        
        void printStack() {
            if(root == null) {
            System.out.println("Stack Underflow");
        }
        else {
            StackLL iter = root;
            System.out.print("Elements present in stack: ");
            while(iter != null) {
                System.out.print(iter.data + " ");
                iter = iter.next;
            }
        }
        
        public static void main(String[] args) {
        StackLL sll = new StackLL();

        s.push(10);
        s.push(20);
        s.push(30);
            
        System.out.println(sll.pop() + " is popped from the stack");
        System.out.println("Is the stack empty: " + sll.isEmpty());
        System.out.println(sll.peek());
        sll.printStack();
    }
}
```

OUTPUT:

![image-20210503124554755](C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210503124554755.png)

### Arithmetic Expression Evaluation:

we mostly represent expressions in **INFINX NOTATION** (A+B)

- each operator is written between two operands
- hence to distinguish between (A+B)xC and A+(BxC) we use parenthesis or some operator precedence convention

1. polish notation (prefix):
   - in this notation operator is placed before its two operands
   - no parenthesis is required
   - eg: +AB
2. reverse polish notation (postfix):
   - in this notation operator is placed after its two operands
   - no parenthesis is required
   - eg: AB+

operator precedence:

exponentiation (^)
multiplication(*) and division(/)
addition(+) and subtraction(-)

eg: here x == multiplication

```
Infix notation: (A-B)x[C/(D+E)+F]
Post-fix notation:AB-CDE+/F+*
```

(A-B)x[C/(D+E)+F]
AB- and DE+
C(DE+)/
(C(DE+)/F)+
== AB-CDE+/F+x

##### by using stack:

1. Infix to Postfix

convert notation to postfix
push operands into stack in the order they appear

```java
static String infixToPostfix(String exp) {
	String result = new String("");
    Stack<Charachter> stack = new Stack<>();
    
    for(int i = 0; i < exp.length(); ++i) {
        char c = exp.charAt(i);
        if(Character.isLetterOrDigit(c)) result += c;
        else if(c == '(') stack.push(c);
        else if(c== ')') {
            while(!stack.isEmpty()) && stack.peek != '(') 
                result += stack.pop;
            stack.pop();
        }
        else {
            while(!stack.isEmpty() && Prec(c) < Prec(stack.peek()))
                result += stack.pop();
            stack.push(c);
        }
    }
    while(!stack.isEmpty()) {
        if(stack.peek() == '(')
            return "Invalid Expression";
        result += stack.pop;
    }
    return result;
}

static int Prec(char ch){
    switch (ch){
        case '+':
        case '-':
            return 1;

        case '*':
        case '/':
            return 2;

        case '^':
            return 3;
    }
    return -1;
}

public static void main(String[] args) {
	String exp = "a+b*(c^d-e)^(f+g*h)-i";
	System.out.println(infixToPostfix(exp));
}
```



