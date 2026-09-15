package com.Tushar.dsajava.arrays.productofarrayexceptself;

public class Solution {

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        int prefixProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return result;
    }
}