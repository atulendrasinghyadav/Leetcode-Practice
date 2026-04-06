```java
// Problem Name: Longest Substring Without Repeating Characters (LeetCode 3)

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> charIndexMap = new HashMap<>(); // Stores the last seen index of each character
        int maxLength = 0;
        int left = 0; // Left pointer of the sliding window

        // Right pointer iterates through the string
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the current character is already in the map and its last seen index
            // is within the current window [left, right], it means we have a repetition.
            // We need to move the left pointer to the right of the previous occurrence.
            if (charIndexMap.containsKey(currentChar)) {
                // We use Math.max here because 'left' might have already moved past
                // the previous occurrence of 'currentChar' due to an earlier duplicate.
                // We always want 'left' to be at least 'charIndexMap.get(currentChar) + 1'
                // to ensure the window contains no duplicates.
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }

            // Update the last seen index of the current character
            charIndexMap.put(currentChar, right);

            // Calculate the current window's length (right - left + 1)
            // and update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
```