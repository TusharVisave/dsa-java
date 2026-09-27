# Implement Queue using Stacks

## Problem

Implement a First-In-First-Out (FIFO) queue using only two standard stacks. The implemented queue must support all standard queue operations:

* `void push(int x)` — Pushes element `x` to the back of the queue.
* `int pop()` — Removes the element from the front of the queue and returns it.
* `int peek()` — Returns the element at the front of the queue without removing it.
* `boolean empty()` — Returns `true` if the queue is empty, `false` otherwise.

### Notes:
* You must use only standard stack operations (`push`, `pop`, `peek`, `size`, `isEmpty`).
* Depending on your language, stacks may be implemented using `Deque` or `ArrayDeque`.

---

## Pattern

**Two Stacks (In-Stack / Out-Stack) with Lazy Amortization**

A single stack provides Last-In-First-Out (LIFO) access. By chaining two stacks together, reversing the elements twice restores the original First-In-First-Out (FIFO) order:
1. `inStack`: Receives incoming elements (`push`).
2. `outStack`: Delivers outgoing elements in FIFO order (`pop`, `peek`).

Elements are transferred lazily from `inStack` to `outStack` only when `outStack` becomes empty.

---

## Approach

1. **State Maintenance**:
   - Maintain `inStack` and `outStack` as two `Deque<Integer>` instances.
2. **Push (`push(x)`)**:
   - Push `x` directly onto `inStack`.
   - Time complexity is strictly $\mathcal{O}(1)$.
3. **Lazy Transfer (`shiftStacks`)**:
   - When a `pop()` or `peek()` operation is requested:
     - If `outStack` is empty, pop every element from `inStack` one by one and push it onto `outStack`.
     - This inverts the order: the oldest element in `inStack` (at the bottom) becomes the top element in `outStack`.
     - If `outStack` already contains elements, do not transfer yet (doing so prematurely would disrupt FIFO order).
4. **Pop (`pop()`)**:
   - Call `shiftStacks()`.
   - If `outStack` is still empty, throw `IllegalStateException("Queue is empty")`.
   - Return `outStack.pop()`.
5. **Peek (`peek()`)**:
   - Call `shiftStacks()`.
   - If `outStack` is still empty, throw `IllegalStateException("Queue is empty")`.
   - Return `outStack.peek()`.
6. **Empty (`empty()`)**:
   - Return `true` if both `inStack.isEmpty()` and `outStack.isEmpty()` are true.

### Walkthrough

| Operation | `inStack` (bottom → top) | `outStack` (bottom → top) | Returned | Note |
|:---|:---:|:---:|:---:|:---|
| `push(1)` | `[1]` | `[]` | — | Direct push to inStack |
| `push(2)` | `[1, 2]` | `[]` | — | Direct push to inStack |
| `peek()` | `[]` | `[2, 1]` | `1` | `outStack` empty → shift: `1` on top |
| `pop()` | `[]` | `[2]` | `1` | Pop from `outStack` |
| `push(3)` | `[3]` | `[2]` | — | Direct push to `inStack` (outStack untouched) |
| `pop()` | `[3]` | `[]` | `2` | Pop from `outStack` |
| `pop()` | `[]` | `[]` | `3` | `outStack` empty → shift `3` → pop `3` |
| `empty()` | `[]` | `[]` | `true` | Both stacks empty |

---

## Complexity

### Time Complexity

* **`push(x)`**: $\mathcal{O}(1)$ — Single push to `inStack`.
* **`pop()`**: **Amortized $\mathcal{O}(1)$** (Worst-case $\mathcal{O}(n)$ when transfer occurs).
* **`peek()`**: **Amortized $\mathcal{O}(1)$** (Worst-case $\mathcal{O}(n)$ when transfer occurs).
* **`empty()` / `isEmpty()`**: $\mathcal{O}(1)$ — Stack emptiness check.

> **Amortized Analysis**: Across the lifetime of $n$ elements, every element is pushed onto `inStack` once, popped from `inStack` once, pushed onto `outStack` once, and popped from `outStack` once. That is exactly 4 operations per element. Therefore, any sequence of $k$ queue operations takes $\mathcal{O}(k)$ time total, yielding an **amortized $\mathcal{O}(1)$** time per operation.

### Space Complexity

* **$\mathcal{O}(n)$** auxiliary space — At any given time, the total number of elements across `inStack` and `outStack` equals the number of active elements in the queue.

---

## Important Edge Cases

1. **Operations on Empty Queue**: Attempting to `pop()` or `peek()` on an empty queue throws an `IllegalStateException`.
2. **Exhaustion and Refill**: Fully depleting the queue, then pushing new elements and dequeuing again functions seamlessly.
3. **Interleaved Operations**: Alternating between `push` and `pop` preserves FIFO order without corrupting internal state.
4. **Multiple Consecutive Peeks**: Repeated calls to `peek()` observe the front element without shifting or popping.
5. **Negative Values and Zero**: Correctly preserves all integer values including negative numbers and zeroes.
6. **Large Scale Workload**: Handles large batches of elements efficiently within amortized $\mathcal{O}(1)$ bounds.
