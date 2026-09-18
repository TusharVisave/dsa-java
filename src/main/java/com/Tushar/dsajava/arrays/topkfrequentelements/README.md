# Top K Frequent Elements

## Problem

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

## Pattern

HashMap + Frequency Counting + Bucket Sort

## Approach

1. Count the frequency of every number using a HashMap.
2. Create buckets where the index represents frequency.
3. Place each number into the bucket corresponding to its frequency.
4. Traverse the buckets from highest frequency to lowest frequency.
5. Collect elements until `k` elements are found.

## Example

Input:

```text
nums = [1, 1, 1, 2, 2, 3]
k = 2