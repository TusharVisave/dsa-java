package com.Tushar.dsajava.arrays.productofarrayexceptself;

public class Solution {

    /*
     * Approach (Prefix / Suffix Product):
     *
     * Pass 1 — left to right (prefix products):
     *   result[i] = product of all elements to the LEFT of index i.
     *   A running prefixProduct variable is multiplied in as we go.
     *
     * Pass 2 — right to left (suffix products):
     *   result[i] *= product of all elements to the RIGHT of index i.
     *   A running suffixProduct variable is multiplied in as we go.
     *
     * After both passes, result[i] = prefix[i] * suffix[i],
     * which equals the product of every element except nums[i].
     *
     * Why this approach:
     * Division is forbidden by the problem constraints.
     * Two linear passes with O(1) extra space (only the output array)
     * achieve O(n) time without needing two separate auxiliary arrays.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) extra, excluding the output array
     */

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        // Pass 1: fill result with prefix products
        int prefixProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        // Pass 2: multiply in suffix products from the right
        int suffixProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }
}