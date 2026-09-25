# Min Stack

## Problem

Design a stack that supports:

- `push()`
- `pop()`
- `top()`
- `getMin()`

All operations should run in O(1) time.

---

## Approach

Use two stacks:

1. Main stack
2. Minimum stack

The main stack stores all values.

The minimum stack stores the minimum value seen at each relevant level.

### Push Operation

```text
If minStack is empty:
    push value to minStack

Otherwise:
    if value <= current minimum (minStack.peek()):
        push value into minStack

Always push value to main stack.
```

### Pop Operation

```text
Pop value from main stack.
If popped value == current minimum (minStack.peek()):
    pop value from minStack.
Return popped value.
```

### Complexity

- **Time Complexity**:
  - `push()`: O(1)
  - `pop()`: O(1)
  - `top()`: O(1)
  - `getMin()`: O(1)
- **Space Complexity**: O(n) auxiliary space