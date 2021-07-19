# trees:

hierarchical data structures

Tree Vocabulary: 

1. topmost node - **root of the tree**
2. elements directly under an element - **children**
3. elements directly above something - **parent**
4. elements with no children - **leaves**
5. height of the TREE - length of longest path from the root to the leaf
6. depth of the NODE - length of path from the root to the node 

![image-20210424184340405](C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210424184340405.png) 

provide moderate access/selection (linkedlist < trees < arrays)

provide moderate insertion/deletion (arrays < trees < unordered list)

unlike arrays and like linked list, trees don't have upper limit to the number of nodes as nodes are linked using pointers

### applications

-manipulate hierarchical data
-info easy to search
-manipulate sorted list

## binary trees

trees with max two child nodes 

a tree node contains:
-data
-pointer to left child
-pointer to right child

when we create our node, in the starting, both right and left child are null.

```java
class Node {
    int data;
    Node left, right;
    
    public Node (int data) {
        this.data = data;
        left = right = null;
    }
}
```



let's create a tree with 4 nodes like given above:

```java
class Node {
    int data;
    Node left, right;
    
    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    
    BinaryTree() {
        root = null;
    }
    
    //to get the root pointer we instantiate it when we instantiate the BinaryTree
    BinaryTree(int data) {
        root = new Node(data);
    }
    
    public static void main(String[] args) {
        BinaryTree tree  = new BinaryTree();
        
        /* 
              1
            /   \
          null  null     */
        
        tree.root = new Node(1);
        
        /* 
                1
             /     \
           2        3
         /   \     /  \
       null null null null  */
        
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        
        /* 
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
        
        tree.root.left.left = new Node(4);
    }
}


```

<img src="C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210520234332553.png" alt="image-20210520234332553" style="zoom:50%;" />

### properties

1. ***The maximum number of nodes at level ‘l’ of a binary tree is 2^l***
   The level of the root is l = 0;
   l = 0, 2^0 = 1 (root) 
   l = 1, 2^1 = 2 (children of the root node) 

2. ***The*** ***Maximum number of nodes in a binary tree of height ‘h’ is 2^h – 1***. 
   h = max number of nodes on the root to leaf path
   In some books, the height of the root is considered as 1. In this convention, the above formula becomes 2^(h+1) – 1 

3. ***In a Binary Tree with N nodes, minimum possible height or the minimum number of levels Log2(N+1)***

4. ***A Binary Tree with L leaves has at least | Log2L? |+ 1  levels***

5. ***In Binary tree where every node has 0 or 2 children, the*** ***number of leaf nodes is always one more than nodes with two children***.

### types of binary trees

1. full binary tree: 
   -if every node has either 0 or 2 children only
   -we can also say the a full binary tree is a binary tree in which all nodes except leaf nodes have two children

   <img src="C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210603114606491.png" alt="image-20210603114606491" style="zoom: 50%;" />

2. complete binary tree:
   -all levels are completely filled
   -except possibly the last and if the last is not filled at least has all keys as left as possible
   -Binary heap is a perfect example

   <img src="C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210603114709215.png" alt="image-20210603114709215" style="zoom:50%;" />

3. perfect binary tree: 
   -all internal nodes have two children
   -all leaf nodes are at the same level

   -number of leaf nodes = number of internal nodes + 1
   -PBT of height h has 2^h^ - 1 nodes

   <img src="C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210603114736637.png" alt="image-20210603114736637" style="zoom:50%;" />

4. balanced binary tree: 
   -height of tree is O(log n) where n is number of nodes
   -AVL tree: make sure difference between heights of left and right subtrees is at most 1
   -Red Black tree: number of black nodes on every root to leaf paths is the same and there are no adjacent red nodes
   -balanced binary search tree performance wise provide O(log n) time for search, insert and delete

5. degenerate/pathological tree: 
   -every internal node has one child. 
   -performance wise same as linked list

   <img src="C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210603114803459.png" alt="image-20210603114803459" style="zoom:50%;" />

### tree traversal

<img src="C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210603115824925.png" alt="image-20210603115824925" style="zoom:50%;" />

1) Depth First Traversals:

- In order (Left –>Root –>Right) [42513]

  in BST in-order traversal generally gives nodes in a non decreasing order
  to get non decreasing order, a variations of in order traversals reversed can be used

   <img src="C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210603115948633.png" alt="image-20210603115948633" style="zoom:33%;" />

  -traverse left subtree
  -visit the root
  -traverse right subtree

  ```java
  class Node {
      int key;
      Node left, rigth;
      
      public Node(int item) {
          key = item;
          left = right =null;
      }
  }
  
  class Binary Tree {
      Node root;
      
      BinaryTree() {root = null;}
      
      void inOrder() {inOrder(root);}
      
      void inOrder(Node node) {
          if(node == null) return;
          
          //reach the depth bottomest left left child
          inOrder(node.left);
          System.out.print(node.key + " ");
          //reach on to the right child
          inOrder(node.right);
      }
  }
  ```

  OUTPUT: 42513

- Preorder (Root –>Left –>Right) [12453]
  it is used to create a copy of the tree
  used to get prefix expression on of an expression tree

  <img src="C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210603120734461.png" alt="image-20210603120734461" style="zoom:33%;" />

  -visit the root
  -traverse the left subtree
  -traverse the right subtree

  ```java
  class Node {
      Node left, right;
      int key;
      
      public Node(int item) {
          key = item;
          left = rigth = null;
      }
  }
  
  class BinaryTree {
      Node root;
      
      public BinaryTree() {root = null;}
      
      void preOrder() {preOrder{root};}
      
      void preOrder(Node node) {
          if(node == null) return;
          //print the root
          System.out.print(node.key + " ");
          //and then reach the left and print
          preOrder(node.left);
          //as you reach the last left print the traverse the right child as the pointer comes back up towards the root 
          preOrder(node.right);
      }
  } 
  ```

  OUTPUT: 12453

- Post order (Left –> Right –> Root) [45231]
  used to delete the tree
  also helpful to get postfix expression of an expression tree

    <img src="C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210603120402662.png" alt="image-20210603120402662" style="zoom:33%;" />
  -traverse the left subtree
  -traverse the right subtree
  -visit the root

  ```java
  class Node{
  	int key;
  	Node right, left;
  
  	public Node(int item) {
          key = item;
          left = right = null;
      }
  }
  
  class BinaryTree {
      Node root;
      
      public BinaryTree() {root = null;}
      
      void postOrder() {postOrder{root};}
      
      void postOrder(Node node) {
          if (node == null) return;
          
          postOrder(node.left);
          postOrder(node.right);
          System.out.println(node.key + " ");
      }
  }
  ```

  

2) Breadth First Traversal:

- Level order [12345]

  <img src="C:\Users\ishit\AppData\Roaming\Typora\typora-user-images\image-20210603120915988.png" alt="image-20210603120915988" style="zoom:33%;" />

  -find the height
  -as we come to each level from 1 to the height h, find the current level order

  ```java
  class Node{
  	int key;
  	Node right, left;
  
  	public Node(int item) {
          key = item;
          left = right = null;
      }
  }
  
  class BinaryTree {
      Node root;
      
      public BinaryTree() {root = null;}
      
      void levelOrder() {
          int height = height(root);
          
          for(int i = 1, i < height; i++)currentLevelOrder(node, i);
      }
      
      int height(Node root) {
          if(root == null) return 0;
          int leftHeight = 0, rightHeight = 0;
          leftHeight = height(root.left);
          rightHeight = height(root.right);
          if(leftHeight > rightHeight) return leftHeight + 1;
          else return rightHeight + 1;
      }
      
      void currentLevelOrder(Node root, int level) {
          if(root == null) return;
          if(level == 1) {
              System.out.print(root.key + " ");
          }
          
          else if(level>1) {
              currentLevelOrder(root.left, level + 1);
              currentLevelOrder(root.right, level + 1);
          }
      }
  }
  ```

  

###### Now these traversals are brute forces. Hence they take a lot of time. For optimized traversal trees uses stacks and queues for traversals for deep first search and breadth first search. The following time and space analyzation are for the optimized algorithms:

**Space:** 
If we don’t consider size of stack for function calls then O(1) 
otherwise O(h) where h is the height of the tree.
height of the skewed tree is n (no. of elements) so the worst space complexity is O(n)
height is (Log n) for balanced tree so the best space complexity is O(Log n). 

**Time:**
O(n) 
different corner cases. 
Complexity function T(n) — for all problem where tree traversal is involved — can be defined as:
T(n) = T(k) + T(n – k – 1) + c
Where k is the number of nodes on one side of root and n-k-1 on the other side.

