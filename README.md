# Java Algorithms & Data Structures

Algorithms and data structures implemented in Java, from the Introduction to Computer Science and Data Structures courses of my B.Sc. in Computer Science at SCE (Sami Shamoon College of Engineering).

## Projects

| Folder | What it does | Concepts |
|---|---|---|
| [bignum-linked-list](bignum-linked-list) | Arbitrary-size integers stored as a doubly linked list of digits, with addition, subtraction and multiplication | Doubly linked lists, digit-by-digit arithmetic with carry and borrow |
| [recursion](recursion) | Determinant of a matrix, subset sum, prime factors, Tribonacci with memoization, palindromes, word search | Linear, tree and accumulator recursion, memoization |
| [algorithm-problems](algorithm-problems) | Two-sum, longest substring without repeats, longest common prefix, search in a sorted matrix, merge sort, rotting oranges | Hash maps, sliding window, binary search, divide and conquer, BFS on a grid |

## How to run

Requires Java 17 or later.

```bash
cd bignum-linked-list
javac -d out *.java
java -cp out Main
```

The other folders use packages: `java -cp out introtocsHW4.HW4tests` and `java -cp out HW5.HW5Mains`.

The big-number project was written in a pair.

## Author

Shirel Azeroual · Computer Science student, SCE
