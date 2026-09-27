# Evaluate Reverse Polish Notation

## Problem

Evaluate the value of an arithmetic expression in **Reverse Polish Notation** (RPN / Postfix Notation).

Valid operators are `+`, `-`, `*`, and `/`. Each operand may be an integer or another expression. Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid (or appropriate exceptions are thrown for invalid input).

### Examples

**Example 1:**
```text
Input: tokens = ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
```

**Example 2:**
```text
Input: tokens = ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
```

**Example 3:**
```text
Input: tokens = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 22
```

---

## Pattern

**Stack (LIFO Operand Evaluation)**

In postfix notation, operands appear before their operators. A **Stack** naturally manages the evaluation order:
1. Operands are pushed onto the stack as they are encountered.
2. When an operator is encountered, the most recent two operands are popped from the stack.
3. The operation is applied to the two operands: `leftOperand operator rightOperand`.
4. The result is pushed back onto the stack for subsequent operations.

---

## Approach

1. Validate that the `tokens` array is non-null and non-empty.
2. Initialize an empty stack `Deque<Integer> stack = new ArrayDeque<>()`.
3. Iterate through each `token` in `tokens`:
   - If `token` is an operator (`+`, `-`, `*`, `/`):
     - Ensure the stack contains at least 2 operands.
     - Pop `right` operand (the top of stack).
     - Pop `left` operand (the preceding value).
     - Compute the result using enhanced `switch`:
       - `+` → `left + right`
       - `-` → `left - right`
       - `*` → `left * right`
       - `/` → check `right != 0` (throw `ArithmeticException` if zero), then `left / right`
     - Push `result` back onto the stack.
   - Else (`token` is a number):
     - Parse the token to an `int` via `Integer.parseInt(token)` and push onto the stack.
4. After processing all tokens, ensure exactly 1 element remains on the stack.
5. Pop and return the final computed value.

---

## Complexity

### Time Complexity

* **$\mathcal{O}(n)$** — We iterate through the $n$ tokens exactly once. Each token triggers either a constant-time push or a constant-time pair of pops, arithmetic evaluation, and push.

### Space Complexity

* **$\mathcal{O}(n)$** — In the worst-case scenario (e.g., all numbers followed by all operators), the stack stores up to $(n + 1) / 2$ operands simultaneously.

---

## Important Edge Cases

* **Single Number**: Tokens with just one number like `["42"]` should return `42` without attempting operator evaluation.
* **Non-commutative Operations (`-`, `/`)**: The first popped element is the *right* operand and the second popped is the *left* operand (`left - right` and `left / right`).
* **Truncation Toward Zero in Division**: In Java, integer division `/` naturally truncates toward zero (e.g., `13 / 5 = 2`, `6 / -132 = 0`, `-7 / 3 = -2`).
* **Division by Zero**: Explicitly guarded and raises `ArithmeticException`.
* **Malformed Expressions**: Extra operators (insufficient operands) or extra unconsumed operands (multiple items remaining on the stack) throw `IllegalArgumentException`.
* **Negative Numbers**: Correctly parses negative integers (e.g. `"-11"`).