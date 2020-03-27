# Lab 4

## Task 1
1. Implement the BST data structure including the following operations: `search`, `min`, `max`, `insert` and `delete`. Use the following class structure:

```java
import java.util.NoSuchElementException;

public class BST {
    private Node root;      // root of BST

    private class Node{
        private int key;    // sorted by key
        private Node left, right, p;
        private int size;   // number of nodes

        public Node(int key, int size){
            this.key = key;
            this.size = size;
            this.left = null;
            this.right = null;
            this.p = null;
        }
    }

    public BST(){
        root = null;
    }
...
```

2. Implement `inOrder`, `preOrder` and `postOrder` traversals.
3. Implement method `checkBST` that verifies whether a binary tree satisfies the BST property.

## Task 2
The standard implementation of insertion in BSTs introduces new values as leaves of the tree. These require the traversal of a full path to be retrieved, making BST non suitable for applications in which newly inserted values are more likely to be retrieved again. Implement the following two strategies to alleviate this problem.
1. Implement `insertRoot`, a method that inserts a new node at the root of a BST. Show that the last key inserted in the tree can be retrieved in O(1) time.
2. Reimplement `search` in such a way that a retrieved key is first removed from the BST and then reinserted at the root.

## Task 3
Extend class `Node` with attribute `private int count` storing the number of duplicated of a given key. Then, modify methods `insert` and `delete` to handle duplicates correctly.

## Task 4
Implement the following algorithm to balance a BST:
1. Perform an inorder traversal of the three and store the keys in a sorted array.
2. Pick the middle element of the array as the root of the new tree.
3. Recursively do the same with the left half of the array and the righ half of the array to get the roots of the left and right subtrees, respectively.