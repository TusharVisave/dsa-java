
# Valid Parentheses

## Problem

Given a string containing the characters `(`, `)`, `{`, `}`, `[` and `]`, determine whether the brackets are valid.

A valid string must satisfy:

1. Every opening bracket has a corresponding closing bracket.
2. Brackets are closed using the same type.
3. Brackets are closed in the correct order.

### Examples

| Input | Output |
|---|---|
| `()` | `true` |
| `()[]{} ` | `true` |
| `([{}])` | `true` |
| `{[()]}` | `true` |
| `(]` | `false` |
| `([)]` | `false` |
| `]` | `false` |
| `(((` | `false` |
| `""` | `true` |

---

## Approach

Use a **Stack** to keep track of opening brackets.

For every character:

1. If it is an opening bracket, push it onto the stack.
2. If it is a closing bracket:
    - Return `false` if the stack is empty.
    - Pop the most recent opening bracket.
    - Check whether the opening and closing brackets match.
3. After processing the entire string, the stack must be empty.

### Example

For:

```text
([{}])