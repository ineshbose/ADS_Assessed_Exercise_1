# Lab 3

## Task 1
Implement in Java the merge sort algorithm for linked lists. Use the following class structure to implement linked lists.

```
public class LinkedList<Item>{
    private Node<Item> head;
    private static class Node<Item>{
        private Item key;
        private Node<Item> next;
    }
    public LinkedList(){
        head = null;
    }
...
```

## Task 2
1. Implement in Java the dequeue abstract data type. Use resizable arrays in a circular fashion in the class below.

```
public class ResizingDequeue<Item>{
    private Item[] q;
    private int n; // number of elements in the dequeue
    private int tail;
    private int head;
    public ResizingDequeue (){
        q = (Item[]) new Object[2];
        n = 0;
        head = 0;
        tail = 0;
    }
...
```

2. Implement the dequeue abstract data type using a circular doubly linked list. Modify the class structure given in 1a for singly linked lists to include `prev` pointers and a sentinel.

## Task 3
1. Implement the Stack ADT using the Dequeue implemented in Task 2(2).
2. Implement the Queue ADT using the Dequeue implemented in Task 2(2).
3. Implement the Queue ADT using two stacks.

## Task 4
Using an auxiliary stack, implement an iterative version of quicksort. To reduce the stack size, first push the indexes of the smaller subarray.