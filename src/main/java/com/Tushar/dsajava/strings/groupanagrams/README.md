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

## Example

Input:

```text
["eat", "tea", "tan", "ate", "nat", "bat"]