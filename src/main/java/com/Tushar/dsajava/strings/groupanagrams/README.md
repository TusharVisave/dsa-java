# Group Anagrams

## Problem

Given an array of strings, group the strings that are anagrams of each other.

Two strings are anagrams when they contain the same characters with the same frequencies.

## Pattern

HashMap + Character Frequency

## Approach

Use a HashMap where:

- Key = character-frequency signature.
- Value = list of strings having that signature.

For each string:

1. Create a frequency array of 26 characters.
2. Count the occurrence of each character.
3. Build a unique key from the frequency array.
4. Use the key in the HashMap.
5. Add the string to the corresponding group.

Anagrams produce the same frequency signature, so they are placed in the same group.

## Why This Approach?

Sorting each string and using it as a key is a common alternative but takes O(n · m log m) time.

The frequency-array key approach avoids sorting and runs in O(n · m) time, where m is the average string length.

This makes it strictly more efficient when the strings are long.

## Example

Input:

```text
["eat", "tea", "tan", "ate", "nat", "bat"]
```

Output:

```text
[["eat","tea","ate"], ["tan","nat"], ["bat"]]
```

## Time Complexity

O(n · m)

Where n is the number of strings and m is the average string length.

## Space Complexity

O(n · m)

For storing all strings in the HashMap.

## Edge Cases

- Empty input array.
- Single word.
- All words are anagrams of each other.
- No words share the same characters.
- Words with different lengths (never anagrams).