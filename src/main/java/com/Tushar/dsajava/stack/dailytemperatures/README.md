# Daily Temperatures

## Problem

Given an array of integers `temperatures` representing the daily temperatures, return an array `answer` such that `answer[i]` is the number of days you have to wait after the `i-th` day to get a warmer temperature. If there is no future day for which this is possible, keep `answer[i] == 0`.

---

## Pattern

**Monotonic Decreasing Stack**

A monotonic stack keeps elements in a specific monotonic order (strictly decreasing or strictly increasing). Here, we maintain a **monotonic decreasing stack of indices**, meaning the temperatures at the stored indices are in descending order from bottom to top.

---

## Approach

1. Initialize an array `result` of the same length as `temperatures`, populated with `0`s.
2. Initialize an empty stack `stack` to store indices of days whose next warmer day has not yet been found.
3. Iterate through the array with index `i`:
   - While the stack is not empty and `temperatures[i] > temperatures[stack.peek()]`:
     - Pop `prevIndex = stack.pop()`.
     - Calculate the waiting days: `result[prevIndex] = i - prevIndex`.
   - Push the current day index `i` onto the stack.
4. Any day indices remaining in the stack have no subsequent warmer day, and their corresponding entries in `result` remain `0`.
5. Return `result`.

### Example Walkthrough

Given `temperatures = [73, 74, 75, 71, 69, 72, 76, 73]`:

| Day `i` | Temp | Stack (indices) | Stack (temperatures) | Actions / Resolved Days |
|:-------:|:----:|:---------------:|:--------------------:|:------------------------|
| 0 | 73 | `[0]` | `[73]` | Push 0 |
| 1 | 74 | `[1]` | `[74]` | 74 > 73: Pop 0 -> `ans[0] = 1-0 = 1`. Push 1 |
| 2 | 75 | `[2]` | `[75]` | 75 > 74: Pop 1 -> `ans[1] = 2-1 = 1`. Push 2 |
| 3 | 71 | `[2, 3]` | `[75, 71]` | 71 < 75: Push 3 |
| 4 | 69 | `[2, 3, 4]` | `[75, 71, 69]` | 69 < 71: Push 4 |
| 5 | 72 | `[2, 5]` | `[75, 72]` | 72 > 69: Pop 4 -> `ans[4] = 5-4 = 1`.<br>72 > 71: Pop 3 -> `ans[3] = 5-3 = 2`.<br>72 < 75: Push 5 |
| 6 | 76 | `[6]` | `[76]` | 76 > 72: Pop 5 -> `ans[5] = 6-5 = 1`.<br>76 > 75: Pop 2 -> `ans[2] = 6-2 = 4`. Push 6 |
| 7 | 73 | `[6, 7]` | `[76, 73]` | 73 < 76: Push 7 |

Unresolved indices `6` and `7` remain `0`.
Final output: `[1, 1, 4, 2, 1, 1, 0, 0]`.

---

## Complexity

- **Time Complexity**: $\mathcal{O}(n)$ — Each index is pushed onto the stack at most once and popped at most once across the entire loop.
- **Space Complexity**: $\mathcal{O}(n)$ — Auxiliary space for the stack and output array.

---

## Important Edge Cases

- **Strictly Increasing Temperatures**: `[30, 40, 50, 60]` -> Every element resolves immediately on the next day `[1, 1, 1, 0]`.
- **Strictly Decreasing Temperatures**: `[90, 80, 70, 60]` -> No element finds a warmer temperature `[0, 0, 0, 0]`.
- **Flat / Equal Temperatures**: `[70, 70, 70]` -> Condition requires *strictly warmer* (`>`), so output is `[0, 0, 0]`.
- **Single Day / Empty Array**: `[80]` -> `[0]`; `[]` -> `[]`.
- **Sub-zero / Negative Temperatures**: `[-5, -10, 0, -2, 5]` -> Correctly handles signed comparisons.
