package com.Tushar.dsajava.arrays.containsduplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /*
     * Approach:
     *
     * 1. Iterate through every number in the array.
     * 2. Attempt to add each number to a HashSet using Set.add(),
     *    which returns false when the element is already present.
     * 3. If add() returns false, a duplicate has been found — return true.
     * 4. If the loop completes without a duplicate, return false.
     *
     * Why this approach:
     * HashSet provides O(1) average-case lookup and insertion, so a single
     * pass is sufficient. No sorting or nested iteration is needed.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}