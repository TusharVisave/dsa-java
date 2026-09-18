package com.Tushar.dsajava.strings.validpalindrome;

public class Solution {

    /*
     * Approach (Two Pointers):
     *
     * 1. Place a left pointer at the start and a right pointer at the end.
     * 2. Advance the left pointer past any non-alphanumeric character.
     * 3. Retreat the right pointer past any non-alphanumeric character.
     * 4. Compare the characters at both pointers (case-insensitive).
     *      If they differ, the string is not a palindrome — return false.
     * 5. Move both pointers inward and repeat until they meet.
     * 6. If all comparisons pass, return true.
     *
     * Why this approach:
     * Using two pointers avoids creating a cleaned copy of the string,
     * keeping space complexity at O(1). Skipping non-alphanumeric characters
     * in-place satisfies the problem's filtering requirement without
     * extra preprocessing.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    public boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            // Skip non-alphanumeric characters from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}