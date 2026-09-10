# Two Sum

## Problem

Given an integer array and a target value, find the indices of two elements whose sum equals the target.

## Approach

First implemented a brute-force approach using two nested loops.

Then optimized the solution using a HashMap.

For each element, calculate the complement as:

`target - current element`

Check whether the complement already exists in the HashMap.

## Why this approach?

The brute-force approach checks every possible pair and takes O(n²) time.

The HashMap approach avoids checking every pair by storing previously visited elements.

This reduces the average time complexity to O(n).

The optimization uses additional memory to improve execution time.

## Time Complexity

Brute Force: O(n²)

Optimized: O(n) average case

## Space Complexity

Brute Force: O(1)

Optimized: O(n)

## Edge Cases

- Empty array.
- Single-element array.
- No valid pair.
- Duplicate values.
- Negative numbers.