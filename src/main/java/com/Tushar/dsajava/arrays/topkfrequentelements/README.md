# Top K Frequent Elements

## Problem

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

You may return the answer in any order.

## Pattern

HashMap + Bucket Sort

## Approach

1. Count the frequency of every number using a HashMap.
2. Create a bucket array where the index represents frequency (size `n + 1`).
3. Place each number into the bucket corresponding to its frequency.
4. Traverse the buckets from highest frequency (index `n`) down to 0.
5. Collect numbers from each bucket until `k` elements are gathered.

## Why This Approach?

A min-heap approach would take O(n log k) time.

The bucket sort approach avoids any heap operations entirely by exploiting the fact that the maximum possible frequency for any element in an array of size `n` is `n`.

This gives a guaranteed O(n) time complexity — strictly better than the heap approach.

## Example

Input:

```text
nums = [1, 1, 1, 2, 2, 3]
k = 2
```

Output:

```text
[1, 2]
```

(1 appears 3 times, 2 appears 2 times — both qualify as the top 2.)

## Time Complexity

O(n)

Building the frequency map takes O(n). Filling buckets takes O(n). Scanning buckets takes O(n).

## Space Complexity

O(n)

For the frequency map and bucket array, both proportional to the input size.

## Edge Cases

- `k` equals the number of unique elements (return all unique elements).
- Single-element array.
- Negative numbers.
- All elements appearing the same number of times.
- Multiple elements with the same frequency competing for the last slot.