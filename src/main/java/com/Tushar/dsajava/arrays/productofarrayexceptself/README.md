# Product of Array Except Self

## Problem

Given an integer array, return an array where each element is equal to the product of all elements in the original array except the element at the current index.

The solution should not use division.

## Approach

Use prefix and suffix products.

### Step 1: Prefix Product

Traverse from left to right.

For each index:

- Store the product of all elements before the current index.
- Update the running prefix product.

### Step 2: Suffix Product

Traverse from right to left.

For each index:

- Multiply the existing result by the product of all elements after the current index.
- Update the running suffix product.

This combines the left-side and right-side products without using division.

## Why This Approach?

A direct solution would calculate the product for every index separately, resulting in O(n²) time.

The prefix/suffix approach processes the array twice and achieves O(n) time.

## Complexity

- Time: O(n)
- Space: O(1) extra space, excluding the output array.

## Pattern

Prefix Product + Suffix Product

## Edge Cases

- Array containing zero
- Multiple zero values
- Negative numbers
- Single-element array