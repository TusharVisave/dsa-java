# DSA in Java

A structured collection of **Data Structures and Algorithms problems implemented in Java**, focused on building strong problem-solving skills, understanding common DSA patterns, and writing clean, testable code.

The repository follows a progressive approach from fundamental array problems to string-based patterns, linked lists, stacks, and will continue toward trees, graphs, and dynamic programming.

---

## 🎯 Objectives

* Build strong DSA fundamentals.
* Learn common problem-solving patterns.
* Implement algorithms from scratch in Java.
* Understand time and space complexity.
* Practice edge-case handling.
* Write clean and maintainable code.
* Validate solutions using automated JUnit tests.
* Maintain a structured GitHub problem-solving portfolio.

---

# 📚 Problems

|  # | Problem                         | Difficulty | Pattern                              | Solution                                                                                  |
| -: | -------------------------------- | ---------- | ------------------------------------ | ------------------------------------------------------------------------------------------ |
|  1 | Two Sum                          | Easy       | Hash Map                             | [View Solution](src/main/java/com/Tushar/dsajava/arrays/twosum)                           |
|  2 | Best Time to Buy and Sell Stock  | Easy       | One Pass                             | [View Solution](src/main/java/com/Tushar/dsajava/arrays/besttimebuyandsellstock)           |
|  3 | Maximum Subarray                 | Medium     | Kadane's Algorithm                   | [View Solution](src/main/java/com/Tushar/dsajava/arrays/maximumsubarray)                  |
|  4 | Contains Duplicate               | Easy       | Hash Set                             | [View Solution](src/main/java/com/Tushar/dsajava/arrays/containsduplicate)                |
|  5 | Product of Array Except Self     | Medium     | Prefix / Suffix Product              | [View Solution](src/main/java/com/Tushar/dsajava/arrays/productofarrayexceptself)         |
|  6 | Top K Frequent Elements          | Medium     | HashMap + Bucket Sort                | [View Solution](src/main/java/com/Tushar/dsajava/arrays/topkfrequentelements)             |
|  7 | Valid Anagram                    | Easy       | Frequency Map                        | [View Solution](src/main/java/com/Tushar/dsajava/strings/validanagram)                    |
|  8 | Group Anagrams                   | Medium     | HashMap + Character Freq.            | [View Solution](src/main/java/com/Tushar/dsajava/strings/groupanagrams)                   |
|  9 | Valid Palindrome                 | Easy       | Two Pointers                         | [View Solution](src/main/java/com/Tushar/dsajava/strings/validpalindrome)                 |
| 10 | Reverse Linked List              | Easy       | In-Place Reversal                    | [View Solution](src/main/java/com/Tushar/dsajava/linkedlist/reverselinkedlist)            |
| 11 | Detect Cycle in Linked List      | Easy       | Fast and Slow Pointers               | [View Solution](src/main/java/com/Tushar/dsajava/linkedlist/detectcycle)                  |
| 12 | Merge Two Sorted Lists           | Easy       | Two Pointers                         | [View Solution](src/main/java/com/Tushar/dsajava/linkedlist/mergetwosortedlists)          |
| 13 | Remove Nth Node From End of List | Medium     | Two Pointers (Gap)                   | [View Solution](src/main/java/com/Tushar/dsajava/linkedlist/removenthnode)               |
| 14 | Intersection of Two Linked Lists | Easy       | Two Pointers (Switching)             | [View Solution](src/main/java/com/Tushar/dsajava/linkedlist/intersectionoflinkedlists)   |
| 15 | Valid Parentheses                | Easy       | Stack (LIFO Matching)                | [View Solution](src/main/java/com/Tushar/dsajava/stack/validparentheses)                  |
| 16 | Min Stack                        | Medium     | Auxiliary Stack / Invariant Tracking | [View Solution](src/main/java/com/Tushar/dsajava/stack/minstack)                          |
| 17 | Daily Temperatures               | Medium     | Monotonic Decreasing Stack           | [View Solution](src/main/java/com/Tushar/dsajava/stack/dailytemperatures)                 |

---

# 🧠 Patterns Covered

## Arrays

### Hash Map

Used to efficiently store and look up previously seen values.

**Problem:**

* Two Sum

### One Pass

Processes the array in a single traversal while maintaining the required state.

**Problem:**

* Best Time to Buy and Sell Stock

### Kadane's Algorithm

Used to find the maximum sum of a contiguous subarray efficiently.

**Problem:**

* Maximum Subarray

### Hash Set

Detects duplicates in a single traversal using constant-time lookups.

**Problem:**

* Contains Duplicate

### Prefix / Suffix Product

Builds the answer using two passes — a running product from the left, then a running
product from the right — to avoid division and stay at O(n) time.

**Problem:**

* Product of Array Except Self

### HashMap + Bucket Sort

Counts element frequencies using a HashMap, then uses a bucket array (indexed by frequency)
to retrieve the top‑k elements in O(n) time without sorting or a heap.

**Problem:**

* Top K Frequent Elements

---

## Strings

### Frequency Map

Counts character frequencies to compare the composition of two strings.

**Problem:**

* Valid Anagram

### HashMap + Character Frequency

Builds a canonical signature from character frequencies and uses a HashMap to bucket
strings that share the same signature.

**Problem:**

* Group Anagrams

### Two Pointers

Uses pointers from both ends of a string and moves them toward the center.

**Problem:**

* Valid Palindrome

---

## Linked Lists

### In-Place Reversal

Reverses pointer directions iteratively during traversal without allocating extra nodes.

**Problem:**

* Reverse Linked List

### Fast and Slow Pointers

Uses two pointers moving at different speeds (Floyd's Cycle-Finding Algorithm) to detect cycles without additional memory.

**Problem:**

* Detect Cycle in Linked List

### Two Pointers

Compares nodes from two sorted lists simultaneously and splices them in sorted order.

**Problem:**

* Merge Two Sorted Lists

### Two Pointers (Gap Strategy)

Maintains a fixed gap of `n` nodes between two pointers to locate and remove a target node from the end of the list in a single pass.

**Problem:**

* Remove Nth Node From End of List

### Two Pointers (Pointer Switching)

Traverses two lists and switches heads upon reaching the end, equalizing traversal distances to identify the intersection node without hash sets.

**Problem:**

* Intersection of Two Linked Lists

---

## Stacks

### Stack (LIFO Matching)

Matches pairs in Last-In-First-Out order, verifying that the most recently opened symbol is closed first.

**Problem:**

* Valid Parentheses

### Auxiliary Stack / Invariant Tracking

Maintains a parallel stack of minimum values to track minimum state across push and pop operations in O(1) time.

**Problem:**

* Min Stack

### Monotonic Decreasing Stack

Maintains indices of unresolved elements whose values are in descending order. When a larger element is encountered, previous elements are popped and resolved in O(1) amortized time per element.

**Problem:**

* Daily Temperatures

---

# 📁 Project Structure

```text
dsa-java/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── Tushar/
│   │               └── dsajava/
│   │                   │
│   │                   ├── arrays/
│   │                   │   ├── twosum/
│   │                   │   ├── besttimebuyandsellstock/
│   │                   │   ├── maximumsubarray/
│   │                   │   ├── containsduplicate/
│   │                   │   ├── productofarrayexceptself/
│   │                   │   └── topkfrequentelements/
│   │                   │
│   │                   ├── strings/
│   │                   │   ├── validanagram/
│   │                   │   ├── groupanagrams/
│   │                   │   └── validpalindrome/
│   │                   │
│   │                   ├── linkedlist/
│   │                   │   ├── reverselinkedlist/
│   │                   │   ├── detectcycle/
│   │                   │   ├── mergetwosortedlists/
│   │                   │   ├── removenthnode/
│   │                   │   └── intersectionoflinkedlists/
│   │                   │
│   │                   └── stack/
│   │                       ├── validparentheses/
│   │                       ├── minstack/
│   │                       └── dailytemperatures/
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── Tushar/
│                   └── dsajava/
│                       ├── arrays/
│                       ├── strings/
│                       ├── linkedlist/
│                       └── stack/
│
├── README.md
├── pom.xml
└── .gitignore
```

---

# 🏗️ Package Structure

All problems use a single consistent package root:

```text
com.Tushar.dsajava
```

The repository is organized by DSA category:

```text
com.Tushar.dsajava
├── arrays
├── strings
├── linkedlist
└── stack
```

This avoids maintaining multiple package roots and keeps the Java project consistent as more problems are added.

---

# 📝 Problem Documentation Structure

Each problem contains its own `README.md` with:

1. Problem
2. Pattern
3. Approach
4. Complexity (Time & Space)
5. Important Edge Cases

This makes every solution independently understandable and interview-ready.

---

# 🧪 Testing

Solutions are tested using **JUnit 5**.

Tests cover:

* Normal cases
* Edge cases
* Empty input
* Single-element/single-character input
* Zero and negative values (where applicable)
* Invalid input scenarios where applicable

Run all tests using:

```bash
./mvnw test
```

Expected result:

```text
Tests run: 102
Failures: 0
Errors: 0
Skipped: 0

BUILD SUCCESS
```

---

# 🔍 Current Problems

## 1. Two Sum

**Pattern:** Hash Map

Finds two numbers in an array whose sum equals a given target. Both a brute-force
(O(n²)) and an optimized hash-map version (O(n)) are implemented, to make the
before/after trade-off explicit.

**Complexity:**

```text
Time  → O(n)
Space → O(n)
```

---

## 2. Best Time to Buy and Sell Stock

**Pattern:** One Pass

Finds the maximum profit from buying and selling a stock once by maintaining the minimum price seen so far.

**Complexity:**

```text
Time  → O(n)
Space → O(1)
```

---

## 3. Maximum Subarray

**Pattern:** Kadane's Algorithm

Finds the contiguous subarray with the largest sum using dynamic programming / Kadane's single pass.

**Complexity:**

```text
Time  → O(n)
Space → O(1)
```

---

## 4. Contains Duplicate

**Pattern:** Hash Set

Determines whether any value appears more than once in an array using constant-time set lookups.

**Complexity:**

```text
Time  → O(n)
Space → O(n)
```

---

## 5. Product of Array Except Self

**Pattern:** Prefix / Suffix Product

Calculates product of all elements except self in two passes without division.

**Complexity:**

```text
Time  → O(n)
Space → O(1) extra (excluding output array)
```

---

## 6. Top K Frequent Elements

**Pattern:** HashMap + Bucket Sort

Finds the `k` most frequent elements using frequency counts mapped to bucket indices in O(n) time.

**Complexity:**

```text
Time  → O(n)
Space → O(n)
```

---

## 7. Valid Anagram

**Pattern:** Frequency Map

Determines whether two strings are anagrams of each other using character counts.

**Complexity:**

```text
Time  → O(n)
Space → O(k)
```

---

## 8. Group Anagrams

**Pattern:** HashMap + Character Frequency

Groups anagrams together using character frequency signatures as map keys.

**Complexity:**

```text
Time  → O(n · m)
Space → O(n · m)
```

---

## 9. Valid Palindrome

**Pattern:** Two Pointers

Validates whether a string is a palindrome after ignoring non-alphanumeric characters.

**Complexity:**

```text
Time  → O(n)
Space → O(1)
```

---

## 10. Reverse Linked List

**Pattern:** In-Place Reversal

Reverses a singly linked list in a single iterative pass by redirecting next pointers.

**Complexity:**

```text
Time  → O(n)
Space → O(1)
```

---

## 11. Detect Cycle in Linked List

**Pattern:** Fast and Slow Pointers (Floyd's Algorithm)

Detects if a linked list contains a cycle using slow (1 step) and fast (2 steps) pointers.

**Complexity:**

```text
Time  → O(n)
Space → O(1)
```

---

## 12. Merge Two Sorted Lists

**Pattern:** Two Pointers

Merges two sorted linked lists into a single sorted list using a dummy head and pointer comparison.

**Complexity:**

```text
Time  → O(n + m)
Space → O(1)
```

---

## 13. Remove Nth Node From End of List

**Pattern:** Two Pointers (Gap Strategy)

Maintains an `n`-step gap between two pointers to remove the target node from the end in a single pass.

**Complexity:**

```text
Time  → O(n)
Space → O(1)
```

---

## 14. Intersection of Two Linked Lists

**Pattern:** Two Pointers (Switching Heads)

Finds the node where two singly linked lists intersect by redirecting each pointer to the other list's head at termination.

**Complexity:**

```text
Time  → O(n + m)
Space → O(1)
```

---

## 15. Valid Parentheses

**Pattern:** Stack (LIFO Matching)

Validates correct nesting and bracket closure for `'()'`, `'{}'`, and `'[]'` using a stack.

**Complexity:**

```text
Time  → O(n)
Space → O(n)
```

---

## 16. Min Stack

**Pattern:** Auxiliary Stack / Invariant Tracking

Designs a stack supporting `push`, `pop`, `top`, and `getMin` in constant O(1) time using a parallel minimum stack.

**Complexity:**

```text
Time  → O(1) for all operations
Space → O(n) auxiliary space
```

---

## 17. Daily Temperatures

**Pattern:** Monotonic Decreasing Stack

Computes the number of days to wait for a warmer temperature for each day using a stack of indices maintaining strictly descending temperatures.

**Complexity:**

```text
Time  → O(n)
Space → O(n)
```

---

# 📊 Complexity Summary

| Problem                         |    Time |    Space | Pattern                              |
| -------------------------------- | ------: | -------: | ------------------------------------ |
| Two Sum                          |    O(n) |     O(n) | Hash Map                             |
| Best Time to Buy and Sell Stock  |    O(n) |     O(1) | One Pass                             |
| Maximum Subarray                 |    O(n) |     O(1) | Kadane's Algorithm                   |
| Contains Duplicate               |    O(n) |     O(n) | Hash Set                             |
| Product of Array Except Self     |    O(n) |     O(1) | Prefix / Suffix Product              |
| Top K Frequent Elements          |    O(n) |     O(n) | HashMap + Bucket Sort                |
| Valid Anagram                    |    O(n) |     O(k) | Frequency Map                        |
| Group Anagrams                   | O(n·m)  |   O(n·m) | HashMap + Char. Frequency            |
| Valid Palindrome                 |    O(n) |     O(1) | Two Pointers                         |
| Reverse Linked List              |    O(n) |     O(1) | In-Place Reversal                    |
| Detect Cycle in Linked List      |    O(n) |     O(1) | Fast and Slow Pointers               |
| Merge Two Sorted Lists           |  O(n+m) |     O(1) | Two Pointers                         |
| Remove Nth Node From End of List |    O(n) |     O(1) | Two Pointers (Gap)                   |
| Intersection of Two Linked Lists |  O(n+m) |     O(1) | Two Pointers (Switching)             |
| Valid Parentheses                |    O(n) |     O(n) | Stack (LIFO Matching)                |
| Min Stack                        |    O(1) |     O(n) | Auxiliary Stack / Invariant Tracking |
| Daily Temperatures               |    O(n) |     O(n) | Monotonic Decreasing Stack           |

---

# 🛠️ Technologies

* **Java 21**
* **Maven**
* **JUnit 5**
* **IntelliJ IDEA**
* **Git**
* **GitHub**

---

# 🌱 Learning Roadmap

The repository will progressively cover the major DSA patterns and data structures.

```text
Arrays
  ↓
Strings
  ↓
Linked Lists
  ↓
Stacks & Queues
  ↓
Binary Search
  ↓
Trees
  ↓
Binary Search Trees
  ↓
Heaps / Priority Queues
  ↓
Graphs
  ↓
Recursion & Backtracking
  ↓
Dynamic Programming
  ↓
Advanced Algorithms
```

---

# 📈 Progress

### Arrays

* [x] Two Sum
* [x] Best Time to Buy and Sell Stock
* [x] Maximum Subarray
* [x] Contains Duplicate
* [x] Product of Array Except Self
* [x] Top K Frequent Elements

### Strings

* [x] Valid Anagram
* [x] Group Anagrams
* [x] Valid Palindrome

### Linked Lists

* [x] Reverse Linked List
* [x] Detect Cycle in Linked List
* [x] Merge Two Sorted Lists
* [x] Remove Nth Node From End of List
* [x] Intersection of Two Linked Lists

### Stacks & Queues

* [x] Valid Parentheses
* [x] Min Stack
* [x] Daily Temperatures

### Upcoming

* [ ] Binary Search
* [ ] Trees & Binary Search Trees
* [ ] Heaps / Priority Queues
* [ ] Graphs
* [ ] Recursion & Backtracking
* [ ] Dynamic Programming

---

# 🎯 Goal

The goal of this repository is to develop strong **problem-solving ability and DSA fundamentals in Java** through consistent implementation and testing.

The focus is on:

```text
Understand the Problem
        ↓
Identify the Pattern
        ↓
Design the Approach
        ↓
Implement in Java
        ↓
Analyze Complexity
        ↓
Test Edge Cases
        ↓
Document the Solution
```

Each problem is intended to strengthen both **coding ability and algorithmic reasoning** for technical interviews and competitive programming.
