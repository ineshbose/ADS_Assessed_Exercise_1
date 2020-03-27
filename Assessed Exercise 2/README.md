# Assessed Exercise 1
The exercise has two parts. The first involves implementing in Java the Dynamic Set abstract data type using two different data structures. The second involves running an empirical study to compare the performance of each implementation.

## Part 1
The _Dynamic Set_ is an abstract data type (ADT) that can store distinct elements, without any particular order. There are five main operations in the ADT:

* ADD(S,_x_): add element _x_ to S, if it is not present already
* REMOVE(S,_x_): remove element _x_ from S, if it is present
* IS-ELEMENT(S,_x_): check whether element _x_ is in set S
* SET-EMPTY(S): check whether set S has no elements
* SET-SIZE(S): return the number of elements of set S

Additionally, the Dynamic Set ADT defines the following set-theoretical operations:

* UNION(S,T): return the union of sets S and T
* INTERSECTION(S,T): return the intersection of sets S and T
* DIFFERENCE(S,T): returns the difference of sets S and T
* SUBSET(S,T): check whether set S is a subset of set T

Implement in Java the Dynamic Set ADT defined above using
1. a doubly linked list, and
2. a binary search tree.

Explain the implementation in the report, noting the running time of each operation in both implementations. Self-balancing binary trees can be used, but no extra marks will be awarded. Java library classes are not allowed for the implementation.

3. Suppose the implementation based on a doubly linked list maintains the list sorted. Explain in the report what are the implications of such implementation choice on the complexity of operations ADD and IS-ELEMENT?
4. A naive implementation of operation UNION(S,T) in the implementation based on BST consists in taking all elements of BST S one by one, and insert them into BST T. Describe in the report an implementation with a better running time.

## Part 2
1. Compare the two implementations of the Dynamic Set ADT by carrying out the following empirical study. First, populate (an initially empty) set S with all the elements from dataset `int20k.txt`. Then, generate 100 random numbers in the interval [0, 49999]. Finally, for each random number _x_ record the time taken to execute IS-ELEMENT(S,_x_). What is the average running of IS-ELEMENT over 100 calls in the two implementations of the ADT?
2. What is the output of SET-SIZE(S)?
3. What is the height of the BST implementing set S?

## Grading
This exercise counts for 10% of the total assessment mark for the course. It is worth a total of 30 points.
Part 1 has four parts for 9, 9, 2 and 5 marks respectively. Part 2 has three parts for 3, 1 and 1 respectively.
The grading follows the University's system for late submission. <br />